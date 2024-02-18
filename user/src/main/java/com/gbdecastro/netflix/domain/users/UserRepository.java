package com.gbdecastro.netflix.domain.users;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {
}
