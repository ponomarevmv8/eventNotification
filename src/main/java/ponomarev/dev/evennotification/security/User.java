package ponomarev.dev.evennotification.security;

public record User(
        Long id,
        String username,
        String role
) {
}
