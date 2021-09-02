package com.felece.felece_case.Services.Role;

import com.felece.felece_case.Models.Role.Role;
import com.felece.felece_case.Models.Role.RoleResponse;
import com.felece.felece_case.Models.User.User;
import com.felece.felece_case.Models.User.UserResponse;
import com.felece.felece_case.Models.Side.UserRoleRequest;
import com.felece.felece_case.Repo.Role.RoleRepo;
import com.felece.felece_case.Repo.User.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleImpl implements RoleService{
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;

    @Override
    public Mono<RoleResponse> saveRole(Role newRole) {
        Role role = Role.builder().id(UUID.randomUUID().toString())
                .name(newRole.getName()).build();

        return roleRepo.save(role).map(this::mapToResponse);
    }

    @Override
    public Flux<RoleResponse> getAllRoles() {
        return roleRepo.findAll().map(this::mapToResponse);
    }

    @Override
    public Flux<UserResponse> addRoleToUser(UserRoleRequest userRoleRequest) {
        User user = userRepo.findByUsername(userRoleRequest.getUsername()).block();
        Role role = roleRepo.findByName(userRoleRequest.getName()).block();
        user.getRoles().add(role);
        userRepo.save(user).block();
        return  userRepo.findAll().map(this::mapToResponseUser);
    }

    @Override
    public Flux<UserResponse> delRoleFromUser(UserRoleRequest userRoleRequest) {
        User user = userRepo.findByUsername(userRoleRequest.getUsername()).block();
        Role role = roleRepo.findByName(userRoleRequest.getName()).block();
        user.getRoles().remove(user.getRoles().indexOf(role));
        userRepo.save(user).block();
        return userRepo.findAll().map(this::mapToResponseUser);
    }

    private RoleResponse mapToResponse(Role role) {
        return RoleResponse.builder().id(role.getId())
                .name(role.getName())
                .build();
    }

    private UserResponse mapToResponseUser(User user) {
        return UserResponse.builder().id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .mail(user.getMail())
                .gender(user.getGender())
                .roles(user.getRoles())
                .build();
    }
}
