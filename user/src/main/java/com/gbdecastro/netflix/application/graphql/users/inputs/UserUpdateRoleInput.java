package com.gbdecastro.netflix.application.graphql.users.inputs;

import com.gbdecastro.netflix.domain.users.ValidRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRoleInput {

    @NotNull(message = "{role_required}")
    @NotEmpty(message = "{role_required}")
    @ValidRole
    private String role;
}
