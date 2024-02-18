package com.gbdecastro.netflix.application.graphql.users.queries;

import com.gbdecastro.netflix.domain.users.UserEntity;
import com.gbdecastro.netflix.domain.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserQueryResolver {

    @Autowired
    private UserService userService;


    @QueryMapping
    public Mono<UserEntity> userById(@Argument String id) {
        return userService.getById(id);
    }

    @QueryMapping
    public Flux<UserEntity> allUsers() {
        return userService.getAll();
    }
}
