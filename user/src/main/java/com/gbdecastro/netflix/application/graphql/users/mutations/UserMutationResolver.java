package com.gbdecastro.netflix.application.graphql.users.mutations;

import com.gbdecastro.netflix.application.graphql.users.inputs.UserInput;
import com.gbdecastro.netflix.application.graphql.users.inputs.UserUpdateRoleInput;
import com.gbdecastro.netflix.domain.users.UserEntity;
import com.gbdecastro.netflix.domain.users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class UserMutationResolver {

    @Autowired
    private UserService userService;


    @MutationMapping
    public Mono<UserEntity> createUser(@Valid @Argument UserInput input) {
        return userService.create(input);
    }

    @MutationMapping
    public Mono<UserEntity> updateUser(@Argument String id, @Valid @Argument UserInput input) {
        return userService.update(id, input);
    }

    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Mono<UserEntity> updateUserRole(@Argument String id, @Valid @Argument UserUpdateRoleInput input) {
        return userService.updateRole(id, input.getRole());
    }
}