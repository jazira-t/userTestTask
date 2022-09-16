package kg.megacom.usertesttask.service;

import kg.megacom.usertesttask.models.User;
import kg.megacom.usertesttask.models.UserTimestamp;
import kg.megacom.usertesttask.models.dto.UserDto;
import kg.megacom.usertesttask.models.enums.UserStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);
    UserDto getById(Long id);
    UserDto update(Long id, UserStatus status);
    UserDto addUser(UserDto userDto, MultipartFile file);
    List<UserDto> findAllUsers(Long userId);

}
