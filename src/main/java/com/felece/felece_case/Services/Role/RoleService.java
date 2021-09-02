package com.felece.felece_case.Services.Role;

import com.felece.felece_case.Models.Role.Role;
import com.felece.felece_case.Models.Role.RoleResponse;
import com.felece.felece_case.Models.User.UserResponse;
import com.felece.felece_case.Models.Side.UserRoleRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoleService {
    Mono<RoleResponse> saveRole(Role role);
    Flux<RoleResponse> getAllRoles();
    Flux<UserResponse> addRoleToUser(UserRoleRequest userRoleRequest);
    Flux<UserResponse> delRoleFromUser(UserRoleRequest userRoleRequest);
}
