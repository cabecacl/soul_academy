package br.com.soul_academy.http.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateUserRequest {
    @NotNull
    private Long id;
    private String password;
    private Long idRole;
}
