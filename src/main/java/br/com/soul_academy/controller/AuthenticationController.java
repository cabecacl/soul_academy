package br.com.soul_academy.controller;

import br.com.soul_academy.domain.user.DataAuthentication;
import br.com.soul_academy.domain.user.User;
import br.com.soul_academy.repository.UserRepository;
import br.com.soul_academy.infra.security.DataTokenJWT;
import br.com.soul_academy.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuthentication dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var autentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.createToken((User) autentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }


}
