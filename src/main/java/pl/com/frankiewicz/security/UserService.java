package pl.com.frankiewicz.security;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> findAll();
    UserDTO addUser(UserDTO productDTO, String password);

}
