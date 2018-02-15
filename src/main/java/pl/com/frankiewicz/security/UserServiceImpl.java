package pl.com.frankiewicz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public void registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTO(userRepository.findAll());
    }

    @Override
    public UserDTO addUser(UserDTO userDTO, String password) {
        User user = new User();

        //if(userDTO.getEmail(userRepository.findUserByEmail()))
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(password));
        return userMapper.toUserDTO(userRepository.save(user));
    }
}
