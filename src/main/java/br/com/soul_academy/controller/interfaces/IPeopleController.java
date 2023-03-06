package br.com.soul_academy.controller.interfaces;

import br.com.soul_academy.domain.people.People;
import br.com.soul_academy.http.dto.request.CreatePeopleRequest;
import br.com.soul_academy.http.dto.request.UpdatePeopleRequest;
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

@Tag(name = "Pessoa")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/people")
public interface IPeopleController {

    @Operation(summary = "Realiza a inclusão de uma pessoa.")
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
                                           "name": "JOÃO DA SILVA SAURO",
                                           "registrationNumber": "999.999.999-99",
                                           "phoneNumber": "81999999999",
                                           "email": "email@email.com",
                                           "address" : "Rua dos bobos, 0",
                                           "idCity": {
                                                "id": 26,
                                                "name": "Recife",
                                                "state" : {
                                                    "id": 25,
                                                    "name": "Pernambuco",
                                                    "federativeUnit": "PE"
                                                    }
                                                },
                                           "typeOfPeople": "Aluno",
                                           "user": {
                                                "id": 1,
                                                "login": "login",
                                                "role": {
                                                    "id": 1,
                                                    "role": "USER"
                                                }
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
                    Dados para incluir um cadastro de pessoa.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                         "name": "JOÃO DA SILVA SAURO",
                                         "registrationNumber": "999.999.999-99",
                                         "phoneNumber": "81999999999",
                                         "email": "email@email.com",
                                         "address" : "Rua dos bobos, 0",
                                         "idCity": 26,
                                         "typeOfPeople": "Aluno",
                                         "login": "login"
                                     }
                                    """
                    )
            )
    )
    @PostMapping
    ResponseEntity<People> save(@RequestBody @Valid CreatePeopleRequest request);

    @Operation(summary = "Realiza a alteração de uma pessoa.")
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
                                           "name": "JOÃO DA SILVA SAURO",
                                           "registrationNumber": "999.999.999-99",
                                           "phoneNumber": "81999999999",
                                           "email": "email@email.com",
                                           "address" : "Rua dos bobos, 0",
                                           "idCity": {
                                                "id": 26,
                                                "name": "Recife",
                                                "state" : {
                                                    "id": 25,
                                                    "name": "Pernambuco",
                                                    "federativeUnit": "PE"
                                                    }
                                                },
                                           "typeOfPeople": "Aluno",
                                           "user": {
                                                "id": 1,
                                                "login": "login",
                                                "role": {
                                                    "id": 1,
                                                    "role": "USER"
                                                }
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
                    Dados para atualizar um cadastro de pessoa.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {    "id" : 1,
                                         "name": "JOÃO DA SILVA SAURO",
                                         "registrationNumber": "999.999.999-99",
                                         "phoneNumber": "81999999999",
                                         "email": "email@email.com",
                                         "address" : "Rua dos bobos, 0",
                                         "idCity": 26,
                                         "typeOfPeople": "Aluno",
                                         "login": "login"
                                     }
                                    """
                    )
            )
    )
    @PutMapping
    ResponseEntity<People> update(@RequestBody @Valid UpdatePeopleRequest request);

    @Operation(summary = "Realiza a listagem de um ou mais cadastros de pessoa.")
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
                                           "name": "JOÃO DA SILVA SAURO",
                                           "registrationNumber": "999.999.999-99",
                                           "phoneNumber": "81999999999",
                                           "email": "email@email.com",
                                           "address" : "Rua dos bobos, 0",
                                           "idCity": {
                                                "id": 26,
                                                "name": "Recife",
                                                "state" : {
                                                    "id": 25,
                                                    "name": "Pernambuco",
                                                    "federativeUnit": "PE"
                                                    }
                                                },
                                           "typeOfPeople": "Aluno",
                                           "user": {
                                                "id": 1,
                                                "login": "login",
                                                "role": {
                                                    "id": 1,
                                                    "role": "USER"
                                                }
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
                    Dados para listar um cadastro de pessoa.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {    "id" = 1,
                                         "name": "JOÃO DA SILVA SAURO",
                                         "registrationNumber": "999.999.999-99"
                                     }
                                    """
                    )
            )
    )
    @GetMapping
    ResponseEntity<List<People>> list(@RequestParam Long id,
                                      @RequestParam String name,
                                      @RequestParam String registrationNumber);

    @Operation(summary = "Realiza a exclusão de uma pessoa.")
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
                    Dados para excluir um cadastro de pessoa.
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
