package br.com.soul_academy.controller;

import br.com.soul_academy.controller.interfaces.IUserController;
import br.com.soul_academy.domain.user.User;
import br.com.soul_academy.http.dto.request.CreateUserRequest;
import br.com.soul_academy.http.dto.request.UpdateUserRequest;
import br.com.soul_academy.service.user.CreateUserService;
import br.com.soul_academy.service.user.DeleteUserService;
import br.com.soul_academy.service.user.FindUserService;
import br.com.soul_academy.service.user.UpdateUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/user")
public class UserController implements IUserController {
    private final CreateUserService createUserService;
    private final UpdateUserService updateUserService;
    private final FindUserService findUserService;
    private final DeleteUserService deleteUserService;

    @Override
    public ResponseEntity<User> save(@RequestBody @Valid CreateUserRequest request) {
        var user = createUserService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @Override
    public ResponseEntity<User> update(UpdateUserRequest request) {
        var user = updateUserService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @Override
    public ResponseEntity<List<User>> list(@RequestParam(required = false) Long id,
                                           @RequestParam(required = false) String login,
                                           @RequestParam(required = false) Long idRole) {
        List<User> lstUser = new ArrayList<>();
        if (id != null) {
            lstUser.add(findUserService.findById(id));
        } else if ((!login.isBlank()) && (!login.isEmpty())) {
            lstUser.add(findUserService.findByLogin(login));
        }
//        else if (idRole != null) {
//            lstUser.addAll(findUserService.findAllByRole(idRole));
//        }
        return ResponseEntity.status(HttpStatus.CREATED).body(lstUser);
    }

    @Override
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        deleteUserService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(singletonMap("message", "Repasse/Sangria deletado com sucesso."));
    }
}
