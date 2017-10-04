package vn.menugo.server.configurations.security.csrf;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@Component("spec")
public class RequestMatcherSpecific implements RequestMatcher {
    // Always allow the HTTP GET method
    private Pattern allowedMethods = Pattern.compile("^(GET|POST)$");

    // Disable CSFR protection on the following urls:
    private AntPathRequestMatcher[] requestMatchers = {
            new AntPathRequestMatcher("/login"),
            new AntPathRequestMatcher("/logout"),
            new AntPathRequestMatcher("/verify/**")
    };

    @Override
    public boolean matches(HttpServletRequest request) {
        // Skip allowed methods
        if (allowedMethods.matcher(request.getMethod()).matches()) {
            return false;
        }

        // If the request match one url the CSFR protection will be disabled
        for (AntPathRequestMatcher rm : requestMatchers) {
            if (rm.matches(request)) {
                return false;
            }
        }

        return true;
    } // method matches

}
