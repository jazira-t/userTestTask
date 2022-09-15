package kg.megacom.usertesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("kg.megacom.usertesttask.microservices")
public class UserTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTestTaskApplication.class, args);
    }

}
