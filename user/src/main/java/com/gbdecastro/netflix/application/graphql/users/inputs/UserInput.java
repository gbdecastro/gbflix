package com.gbdecastro.netflix.application.graphql.users.inputs;

import com.gbdecastro.netflix.domain.users.ValidRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {

    @NotNull(message = "{name_required}")
    @NotEmpty(message = "{name_required}")
    private String name;

    @Email(message = "{email_invalid}")
    private String email;

    @NotNull(message = "{role_required}")
    @ValidRole
    private List<String> roles;
}
