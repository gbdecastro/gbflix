package com.gbdecastro.netflix.domain.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Field
    private String name;
    @Field
    private String email;
    @Field
    private Set<RolesEnum> roles;
}
