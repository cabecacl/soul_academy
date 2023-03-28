package br.com.soul_academy.service.people;

import br.com.soul_academy.domain.people.People;
import br.com.soul_academy.http.dto.request.UpdatePeopleRequest;
import br.com.soul_academy.repository.CityRepository;
import br.com.soul_academy.repository.PeopleRepository;
import br.com.soul_academy.repository.TypeOfPeopleRepository;
import br.com.soul_academy.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPeopleService {
    private final PeopleRepository repository;
    private final String PESSOA_NAO_LOCALIZADA = "Pessoa não localizada.";

    public People findbyId(Long id) {
        var people = repository.findById(id)
                .orElseThrow(() -> new NoResultException(PESSOA_NAO_LOCALIZADA));

        return people;
    }

    public List<People> fidByName(String name) {
        var list = repository.findByName(name)
                .orElseThrow(() -> new NoResultException(PESSOA_NAO_LOCALIZADA));
        return list;
    }

    public People findByRegistrationNumber(String registrationNumber) {
        var people = repository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new NoResultException(PESSOA_NAO_LOCALIZADA));
        return people;
    }
}
