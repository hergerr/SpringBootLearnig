package pl.com.frankiewicz.security;

import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);

    List<UserDTO> toUserDTO(List<User> userDTO);
    List<User> toUser(List<User> userDTO);
}
