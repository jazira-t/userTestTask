package kg.megacom.usertesttask.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "user_timestamp")
public class UserTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long timestamp;
    @ManyToOne
            @JoinColumn(name = "user_id")
    User user;
}
