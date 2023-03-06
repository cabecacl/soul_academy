package br.com.soul_academy.controller.interfaces;

import br.com.soul_academy.domain.user.User;
import br.com.soul_academy.http.dto.request.CreateUserRequest;
import br.com.soul_academy.http.dto.request.UpdateUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuário")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public interface IUserController {
    @Operation(summary = "Realiza a inclusão de um usuário.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a inclusão ocorra com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                       {
                                           "id": 1,
                                           "login": "login",
                                           "role": {
                                               "id": 1,
                                               "role": "USER"
                                           },
                                           "insertedAt" : "25/02/2023 14:30",
                                           "updatedAt" : "25/02/2023 14:30" 
                                       }
                                       """
                            )
                    )
            )
    })
    @RequestBody(
            description = """
                    Dados para incluir um cadastro de usuário.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                         "login": "login",
                                         "password": "password",
                                         "idRole": 1
                                     }
                                    """
                    )
            )
    )
    @PostMapping
    ResponseEntity<User> save(@RequestBody @Valid CreateUserRequest request);

    @Operation(summary = "Realiza a alteração de um usuário.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a alteração ocorra com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                       {
                                           "id": 1,
                                           "login": "login",
                                           "role": {
                                               "id": 1,
                                               "role": "USER"
                                           },
                                           "insertedAt" : "25/02/2023 14:30",
                                           "updatedAt" : "25/02/2023 14:30" 
                                       }
                                       """
                            )
                    )
            )
    })
    @RequestBody(
            description = """
                    Dados para atualizar um cadastro de usuário.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {    "id" : 1,
                                         "password": "password",
                                         "idRole": 1
                                     }
                                    """
                    )
            )
    )
    @PutMapping
    ResponseEntity<User> update(@RequestBody @Valid UpdateUserRequest request);

    @Operation(summary = "Realiza a listagem de um ou mais cadastros de usuários.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a listagem ocorra com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                       {
                                           "id": 1,
                                           "login": "login",
                                           "role": {
                                               "id": 1,
                                               "role": "USER"
                                           },
                                           "insertedAt" : "25/02/2023 14:30",
                                           "updatedAt" : "25/02/2023 14:30" 
                                       }
                                       """
                            )
                    )
            )
    })
    @RequestBody(
            description = """
                    Dados para listar um cadastro de usuário.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {    "id" = 1,
                                         "login": "jss",
                                         "idRole": 1
                                     }
                                    """
                    )
            )
    )
    @GetMapping
    ResponseEntity<List<User>> list(@RequestParam Long id,
                                    @RequestParam String login,
                                    @RequestParam Long idRole);

    @Operation(summary = "Realiza a exclusão de um usuário.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a exclusão ocorra com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                       {
                                           "message": "Cadastro excluído com sucesso." 
                                       }
                                       """
                            )
                    )
            )
    })
    @RequestBody(
            description = """
                    Dados para excluir um cadastro de usuário.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                         "id" : 1
                                     }
                                    """
                    )
            )
    )
    @DeleteMapping
    ResponseEntity<Object> delete(@RequestParam Long id);
}
