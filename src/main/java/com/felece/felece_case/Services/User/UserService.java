package com.felece.felece_case.Services.User;

import com.felece.felece_case.Models.User.User;
import com.felece.felece_case.Models.User.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserResponse> saveUser(User User);
    Flux<UserResponse> getAllUsers();
    Flux<UserResponse> deleteUserById(String id);
    Mono<UserResponse> getUserInfo();
    void register(User user);
}
