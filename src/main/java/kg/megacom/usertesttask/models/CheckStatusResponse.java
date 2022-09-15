package kg.megacom.usertesttask.models;

import lombok.Data;

import java.util.List;

@Data
public class CheckStatusResponse {

    private Long timestamp;
    private List<User> users;
}
