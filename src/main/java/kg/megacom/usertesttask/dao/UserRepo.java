package kg.megacom.usertesttask.dao;

import kg.megacom.usertesttask.models.User;
import kg.megacom.usertesttask.models.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDto, Long> {
}
