package com.felece.felece_case.Repo.User;

import com.felece.felece_case.Models.User.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepo extends ReactiveMongoRepository<User, String> {
    @Query
    public Mono<User> findByUsername(String username);
}
