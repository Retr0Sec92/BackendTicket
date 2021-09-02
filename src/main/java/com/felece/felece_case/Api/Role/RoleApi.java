package com.felece.felece_case.Api.Role;

import com.felece.felece_case.Models.Role.Role;
import com.felece.felece_case.Models.Role.RoleResponse;
import com.felece.felece_case.Models.User.UserResponse;
import com.felece.felece_case.Models.Side.UserRoleRequest;
import com.felece.felece_case.Services.Role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleApi {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<Flux<RoleResponse>> getRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @PostMapping
    public ResponseEntity<Mono<RoleResponse>> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(roleService.saveRole(role));
    }

    @PostMapping("/add")
    public ResponseEntity<Flux<UserResponse>> addRoleToUser(@RequestBody UserRoleRequest userRoleRequest) {
        return ResponseEntity.ok().body(roleService.addRoleToUser(userRoleRequest));
    }

    @PostMapping("/remove")
    public ResponseEntity<Flux<UserResponse>> delRoleFromUser(@RequestBody UserRoleRequest userRoleRequest) {
        return ResponseEntity.ok().body(roleService.delRoleFromUser(userRoleRequest));
    }
}
