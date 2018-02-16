package pl.com.frankiewicz.security;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public interface UserService {
    List<UserDTO> findAll();
    UserDTO addUser(String email, String password) throws MessagingException;

}
