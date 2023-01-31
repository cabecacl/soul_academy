package br.com.soul_academy.controller;

import br.com.soul_academy.domain.user.DataAuthentication;
import br.com.soul_academy.domain.user.User;
import br.com.soul_academy.domain.user.UserRepository;
import br.com.soul_academy.infra.security.DataTokenJWT;
import br.com.soul_academy.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @GetMapping
    public ResponseEntity teste(){
         return ResponseEntity.ok("Teste de acesso realizado - OK");
    }
    

}
