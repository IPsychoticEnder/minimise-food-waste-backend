package net.barnowlstudio.food_waste_backend.persistence;

import net.barnowlstudio.food_waste_backend.persistence.entity.UserEntity;
import org.apache.catalina.User;

import java.util.Optional;

public interface IUserRepository {
    UserEntity save(UserEntity user);
    Optional<UserEntity> getById(long id);
    void updateUser(UserEntity user);
}
