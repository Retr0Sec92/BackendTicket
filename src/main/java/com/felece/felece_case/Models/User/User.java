package com.felece.felece_case.Models.User;

import com.felece.felece_case.Models.Role.Role;
import com.felece.felece_case.Models.Side.UserGender;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    private  String id;
    private  String name;
    private  String password;
    private  String username;
    private  UserGender gender;
    private  String mail;
    private  List<Role> roles;
}
