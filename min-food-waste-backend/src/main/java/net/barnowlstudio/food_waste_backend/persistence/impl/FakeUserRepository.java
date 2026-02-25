package net.barnowlstudio.food_waste_backend.persistence.impl;

import net.barnowlstudio.food_waste_backend.persistence.IUserRepository;
import net.barnowlstudio.food_waste_backend.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class FakeUserRepository implements IUserRepository {
    private Map<Long, UserEntity> savedUsers = new HashMap<>();
    private long nextId = 1;

    public UserEntity save(UserEntity user) {
        if (user.getId() == null) {
            user.setId(nextId);
            nextId++;
            this.savedUsers.put(user.getId(), user);
        }
        return user;
    }

    public Optional<UserEntity> getById(long id) {
        return Optional.ofNullable(savedUsers.get(id));
    }

    public void updateUser(UserEntity user) {
        savedUsers.put(user.getId(), user);
    }
}
