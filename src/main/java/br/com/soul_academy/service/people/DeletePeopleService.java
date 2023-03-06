package br.com.soul_academy.service.people;

import br.com.soul_academy.domain.people.People;
import br.com.soul_academy.repository.PeopleRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeletePeopleService {
    private final PeopleRepository repository;
    private final String PESSOA_NAO_LOCALIZADA = "Pessoa não localizada.";

    public void delete(Long id) {
        var people = repository.findById(id)
                .orElseThrow(() -> new NoResultException(PESSOA_NAO_LOCALIZADA));

        repository.delete(people);
    }
}
