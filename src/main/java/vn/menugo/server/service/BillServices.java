package vn.menugo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.model.Bill;
import vn.menugo.server.repo.BillRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BillServices {
    private final BillRepository billRepository;
    private final AndroidPushNotificationsService notificationsService;

    @Autowired
    public BillServices(BillRepository billRepository, AndroidPushNotificationsService notificationsService) {
        this.billRepository = billRepository;
        this.notificationsService = notificationsService;
    }

    public Bill findByUuid(UUID uuid) {
        return billRepository.getOne(uuid);
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill createBill(UUID puid, String type, long price) {
        Bill bill = new Bill();
        bill.setType(type);
        bill.setPrice(price);

        //todo send notification
        notificationsService.pushNotificationToDevice(puid);

        return billRepository.save(bill);
    }

    public List<Bill> findAll() {
        return billRepository.findAll();
    }
}
