package kg.megacom.usertesttask.service.impl;

import kg.megacom.usertesttask.dao.UserRepo;
import kg.megacom.usertesttask.microservices.FileServiceFeign;
import kg.megacom.usertesttask.microservices.json.Response;
import kg.megacom.usertesttask.microservices.json.UserResponse;
import kg.megacom.usertesttask.models.User;
import kg.megacom.usertesttask.models.UserTimestamp;
import kg.megacom.usertesttask.models.dto.UserDto;
import kg.megacom.usertesttask.models.enums.UserStatus;
import kg.megacom.usertesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FileServiceFeign fileServiceFeign;



    @Override
    public UserDto save(UserDto userDto) {
        return userRepo.save(userDto);
    }

    @Override
    public UserDto getById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    @Override
    public UserDto update(Long id, UserStatus status) {
        UserDto userDto = userRepo.findById(id).orElseThrow();

        UserResponse userResponse = new UserResponse();
        userResponse.setId(id);
        userResponse.setPreviousStatus(userDto.getStatus());

        userDto.setStatus(status);
        userRepo.save(userDto);
        userResponse.setCurrentStatus(userDto.getStatus());
        return userDto;
    }
    @Override
    public UserDto addUser(UserDto userDto, MultipartFile file) {
        Response response = fileServiceFeign.upload(file);
        userDto.setUri(response.getDownloadUri());
        return save(userDto);
    }
    @Override
    public List<UserDto> findAllUsers(Long userId) {
        List<UserDto> userList = userRepo.findAll();
        return userList;
    }

}
