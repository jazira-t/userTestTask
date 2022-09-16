package kg.megacom.usertesttask.controllers;

import kg.megacom.usertesttask.models.CheckStatusResponse;
import kg.megacom.usertesttask.models.User;
import kg.megacom.usertesttask.models.dto.UserDto;
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
    private UserDto addUser(@RequestBody UserDto userDto){
        return  userService.save(userDto);
    }

    @PostMapping("/add/file")
    private UserDto addImageToUser(@RequestParam Long userId, @RequestPart MultipartFile file){
        UserDto userDto = userService.getById(userId);
        return userService.addUser(userDto, file);
    }
    @GetMapping("/get")
    public UserDto getUser(@RequestParam Long userId){
        return (UserDto) userService.findAllUsers(userId);
    }
    @PutMapping("/update")
    public UserDto update(@RequestParam Long id, @RequestParam UserStatus status){
        return userService.update(id, status);
    }

    @GetMapping("/get/users")
    private CheckStatusResponse getUsers(@RequestParam(required = false, defaultValue = "ONLINE") UserStatus status,
                                         @RequestParam(required = false) Date date){
    return getUsers(status, date);
    }

}
