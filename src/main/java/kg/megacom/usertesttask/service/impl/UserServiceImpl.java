package kg.megacom.usertesttask.service.impl;

import kg.megacom.usertesttask.dao.UserRepo;
import kg.megacom.usertesttask.mappers.UserMapper;
import kg.megacom.usertesttask.microservices.FileServiceFeign;
import kg.megacom.usertesttask.microservices.json.Response;
import kg.megacom.usertesttask.models.User;
import kg.megacom.usertesttask.models.dto.UserDto;
import kg.megacom.usertesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FileServiceFeign fileServiceFeign;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        if (userRepo.existsById(user.getId())) {
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public User addUser(User user, MultipartFile file) {
        Response response = fileServiceFeign.upload(file);
        user.setUri(response.getDownloadUri());
        return save(user);
    }

}
