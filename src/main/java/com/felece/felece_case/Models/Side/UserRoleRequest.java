package com.felece.felece_case.Models.Side;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRoleRequest {
    private String username;
    private String name;
}
