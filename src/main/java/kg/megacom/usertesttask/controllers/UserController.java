package kg.megacom.usertesttask.controllers;

import kg.megacom.usertesttask.models.CheckStatusResponse;
import kg.megacom.usertesttask.models.User;
import kg.megacom.usertesttask.models.enums.UserStatus;
import kg.megacom.usertesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    private User addUser(@RequestBody User user){
        return  userService.save(user);
    }

    @PostMapping("/add/file")
    private User addImageToUser(@RequestParam Long userId, @RequestPart MultipartFile file){
        User user = userService.getById(userId);
        return userService.addUser(user, file);
    }

    @GetMapping("/get")
    private CheckStatusResponse getUsers(@RequestParam(required = false, defaultValue = "ONLINE") UserStatus status,
                                         @RequestParam(required = false) Date date){
//// date -> long
//        // dobavit ob'ekt UserTimestamp( Long id, User, Long timestamp) - Many to one, sozdat tablicu UserTimestamp
//        // if (status == Enum && date == null) {} - v servise
    return null;
    }

}
