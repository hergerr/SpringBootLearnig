package pl.com.frankiewicz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService ;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> addProduct(@RequestBody UserDTO userDTO, @RequestParam String password) {
        UserDTO newUser = userService.addUser(userDTO, password);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


}
