package kg.megacom.usertesttask.microservices.json;

import kg.megacom.usertesttask.models.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    UserStatus currentStatus;
    UserStatus previousStatus;

}
