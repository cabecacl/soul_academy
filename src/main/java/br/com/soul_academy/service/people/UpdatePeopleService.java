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

@Service
@RequiredArgsConstructor
public class UpdatePeopleService {
    private final PeopleRepository repository;
    private final CityRepository cityRepository;
    private final TypeOfPeopleRepository typeOfPeopleRepository;
    private final UserRepository userRepository;

    public People execute(UpdatePeopleRequest request) {
        var people = repository.findById(request.getId())
                .orElseThrow(() -> new NoResultException("Pessoa não localizada."));

        var city = cityRepository.findById(request.getIdCity())
                .orElseThrow(() -> new NoResultException("Cidade não localizada."));
        var user = userRepository.findByLogin(request.getLogin())
                .orElseThrow(() -> new NoResultException("Usuário não localizado."));
        var typeOfPeople = typeOfPeopleRepository.findByType(request.getTypeOfPeople())
                .orElseThrow(() -> new NoResultException("Tipo de pessoa não localizado."));

        people.setName(request.getName());
        people.setRegistrationNumber(request.getRegistrationNumber());
        people.setPhoneNumber(request.getPhoneNumber());
        people.setEmail(request.getEmail());
        people.setAddress(request.getAddress());
        people.setZipCode(request.getZipCode());
        people.setCity(city);
        people.setTypeOfPeople(typeOfPeople);
        people.setUser(user);
        people.setUpdatedAt(LocalDateTime.now());
        people = repository.save(people);

        return people;
    }
}
