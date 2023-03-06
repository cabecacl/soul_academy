package br.com.soul_academy.http.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserRequest {

    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private Long idRole;
}
