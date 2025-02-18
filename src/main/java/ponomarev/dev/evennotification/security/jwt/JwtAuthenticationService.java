package ponomarev.dev.evennotification.security.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ponomarev.dev.evennotification.security.User;


@Service
public class JwtAuthenticationService {


    public User getCurrentAuthenticatedUserOrThrow() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalArgumentException("No authentication found");
        }
        return (User) authentication.getPrincipal();
    }
}
