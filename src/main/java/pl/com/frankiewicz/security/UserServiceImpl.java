package pl.com.frankiewicz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.com.frankiewicz.emailVerification.VerificationToken;
import pl.com.frankiewicz.emailVerification.VerificationTokenService;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private VerificationTokenService verificationTokenService;
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, VerificationTokenService verificationTokenService, UserRepository userRepository, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenService = verificationTokenService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    //    public void registerUser(String email, String password) {
//        User user = new User();
//        user.setEmail(email);
//        user.setPassword(passwordEncoder.encode(password));
//    }
//    to jest addUser

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTO(userRepository.findAll());
    }

    @Override
    public UserDTO addUser(String email, String password) throws MessagingException {

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));


        user = userRepository.save(user);
        //dodac generacje tokenu
        verificationTokenService.createToken(user);


        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        ctx.setAuthentication(auth);

        return userMapper.toUserDTO(user);
    }
}
