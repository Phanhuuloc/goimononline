package vn.menugo.server.service;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.menugo.server.model.Provider;
import vn.menugo.server.repo.ProviderRepository;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AndroidPushNotificationsService {
    private final static Logger LOGGER = Logger.getLogger(AndroidPushNotificationsService.class);
    private static final String FIREBASE_SERVER_KEY = "AAAADGGdux8:APA91bHa48Vzx1CRhUWaG895hYVqlVw72UPiZzmYJ0QiY7GeqQyLJdHfYCPPKK0uTmuSr0M0iMr2Shgj9yY1O_SwYdGKjVGF-SywbG5WGi3Sjjelqm__ibNwt18hTepVmRVt9t42heWE";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

    private final ProviderRepository providerRepository;

    @Autowired
    public AndroidPushNotificationsService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    /**
     * Send notification
     *
     * @param entity
     * @return
     */
    private CompletableFuture<String> send(HttpEntity<String> entity) {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);
        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
        return CompletableFuture.completedFuture(firebaseResponse);
    }

    private JSONObject buildData(Provider model) {
        return model.toJSON();
    }

    /**
     * Build the body of FCM
     *
     * @param token device token
     * @return JSONObject present the message body
     * @throws JSONException
     */
    private JSONObject buildBody(String token) throws JSONException {
        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");
        body.put("message", "message");
        return body;
    }

    /**
     * Build the notification part of FCM
     *
     * @param body notification body
     * @return JSONObject present the message notification
     * @throws JSONException
     */
    private JSONObject buildNotification(String body) throws JSONException {
        JSONObject notification = new JSONObject();
        notification.put("title", "New Order");
        notification.put("body", body);
        return notification;
    }

    /**
     * Send finish notification to device
     *
     * @param uid car uid
     * @return ResponseEntity
     */
    public ResponseEntity<String> pushNotificationToDevice(UUID uid){
        Provider provider = providerRepository.findByUuid(uid);
        String token = provider.getToken();
        try {
            JSONObject body = buildBody(token);

            String notify = "New Bill";
            LOGGER.info(String.format("Car finish moving, send %s to server", notify));

            JSONObject notification = buildNotification(notify);
            body.put("notification", notification);

            JSONObject carObj = buildData(provider);
            body.put("data", carObj);

            HttpEntity<String> request = new HttpEntity<>(body.toString());

            CompletableFuture<String> pushNotification = send(request);
            CompletableFuture.allOf(pushNotification).join();

            try {
                String firebaseResponse = pushNotification.get();
                LOGGER.info(firebaseResponse);
                return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error(e.getMessage());
            }
            LOGGER.info("Push Notification ERROR!");
            return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
        }catch (JSONException ignored){
            return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
        }
    }
}
