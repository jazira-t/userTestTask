package kg.megacom.usertesttask.models;

import kg.megacom.usertesttask.models.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "users")
public class User {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String uri;
    @Enumerated(EnumType.STRING)
    UserStatus status;


}
