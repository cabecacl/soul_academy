package br.com.soul_academy.repository;

import br.com.soul_academy.domain.people.TypeOfPeople;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeOfPeopleRepository extends JpaRepository<TypeOfPeople, Long> {

    Optional<TypeOfPeople> findByType(String type);
}
