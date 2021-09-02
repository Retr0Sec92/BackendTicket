package com.felece.felece_case.Repo.Role;

import com.felece.felece_case.Models.Role.Role;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RoleRepo extends ReactiveMongoRepository<Role, String> {
    @Query
    public Mono<Role> findByName(String name);
}
