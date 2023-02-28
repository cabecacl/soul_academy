package br.com.soul_academy.controller;

import br.com.soul_academy.controller.interfaces.IPeopleController;
import br.com.soul_academy.domain.people.People;
import br.com.soul_academy.http.dto.request.CreatePeopleRequest;
import br.com.soul_academy.http.dto.request.UpdatePeopleRequest;
import br.com.soul_academy.service.people.CreatePeopleService;
import br.com.soul_academy.service.people.DeletePeopleService;
import br.com.soul_academy.service.people.FindPeopleService;
import br.com.soul_academy.service.people.UpdatePeopleService;
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
@RequestMapping("/people")
public class PeopleController implements IPeopleController {

    private final CreatePeopleService createPeopleService;
    private final UpdatePeopleService updatePeopleService;
    private final FindPeopleService findPeopleService;
    private final DeletePeopleService deletePeopleService;

    @Override
    public ResponseEntity<People> save(@RequestBody @Valid CreatePeopleRequest request) {
        var people = createPeopleService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(people);
    }

    @Override
    public ResponseEntity<People> update(@RequestBody @Valid UpdatePeopleRequest request) {
        var people = updatePeopleService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(people);
    }

    @Override
    public ResponseEntity<List<People>> list(@RequestParam Long id,
                                             @RequestParam String name,
                                             @RequestParam String registrationNumber) {
        List<People> people = new ArrayList<>();
        if (id != null) {
            people.add(findPeopleService.findbyId(id));
        } else if ((!name.isBlank()) && (!name.isEmpty())) {
            people.addAll(findPeopleService.fidByName(name));
        } else if ((!registrationNumber.isEmpty()) && (!registrationNumber.isBlank())){
            people.add(findPeopleService.findByRegistrationNumber(registrationNumber));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(people);
    }

    @Override
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        deletePeopleService.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(singletonMap("message", "Repasse/Sangria deletado com sucesso."));
    }

//    @GetMapping
//    public ResponseEntity teste(){
//         return ResponseEntity.ok("Teste de acesso realizado - OK");
//    }



}
