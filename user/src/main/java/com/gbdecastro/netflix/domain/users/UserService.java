package com.gbdecastro.netflix.domain.users;

import com.gbdecastro.netflix.application.graphql.users.inputs.UserInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserEntity> getAll();

    Mono<UserEntity> getById(String id);

    Mono<UserEntity> create(UserInput user);

    Mono<UserEntity> update(String id, UserInput toUpdate);

    Mono<UserEntity> updateRole(String id, String role);
}
