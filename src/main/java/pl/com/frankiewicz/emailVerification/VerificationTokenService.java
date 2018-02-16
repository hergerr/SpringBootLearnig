package pl.com.frankiewicz.emailVerification;

import pl.com.frankiewicz.security.User;

import javax.mail.MessagingException;

public interface VerificationTokenService {
    public void verify(String token);
    public void createToken(User user) throws MessagingException;
}
