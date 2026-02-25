package net.barnowlstudio.food_waste_backend.business;

import net.barnowlstudio.food_waste_backend.dto.Request.ChangePasswordRequest;
import net.barnowlstudio.food_waste_backend.dto.Request.CreateUserRequest;
import net.barnowlstudio.food_waste_backend.dto.Request.UpdateUserRequest;
import net.barnowlstudio.food_waste_backend.dto.response.CreateUserResponse;
import net.barnowlstudio.food_waste_backend.dto.response.GetUserByIdResponse;

public interface IUserService {
    GetUserByIdResponse getUserById(Long id);

    CreateUserResponse createUser(CreateUserRequest createUserRequest);

    // TODO :Implement later
    void updateUser (Long userId, UpdateUserRequest request);

    //TODO :Implement later
    void changePassword(Long userId, ChangePasswordRequest request);
}
