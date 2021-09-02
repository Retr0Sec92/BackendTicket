package com.felece.felece_case.Models.Role;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Role {
    @Id
    private  String id;
    private  String name;
}
