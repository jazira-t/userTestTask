package kg.megacom.usertesttask.service;

import kg.megacom.usertesttask.models.User;
import kg.megacom.usertesttask.models.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User save(User user);
    User getById(Long id);
    User update(User user);

    User addUser(User user, MultipartFile file);


}
