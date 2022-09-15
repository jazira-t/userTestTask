package kg.megacom.usertesttask.models.dto;

import kg.megacom.usertesttask.models.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    Long id;
    String name;
    String email;
    String uri;
    UserStatus status;


}
