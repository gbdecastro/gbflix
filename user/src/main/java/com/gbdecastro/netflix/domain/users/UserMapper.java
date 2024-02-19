package com.gbdecastro.netflix.domain.users;

import com.gbdecastro.netflix.application.graphql.users.inputs.UserInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    UserEntity toEntity(UserInput input);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    UserEntity update(@MappingTarget UserEntity user, UserInput userUpdate);
}
