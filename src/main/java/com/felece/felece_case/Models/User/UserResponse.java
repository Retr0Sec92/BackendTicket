package com.felece.felece_case.Models.User;

import com.felece.felece_case.Models.Role.Role;
import com.felece.felece_case.Models.Side.UserGender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UserResponse {
    private  String id;
    private  String name;
    private  String username;
    private  UserGender gender;
    private  String mail;
    private  List<Role> roles;
}
