package br.com.soul_academy.repository;

import br.com.soul_academy.domain.people.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PeopleRepository extends JpaRepository<People, Long> {

    Optional<People> findByRegistrationNumber(String registrationNumber);

    @Query(value = "select " +
        "   p.id, " +
        "   p.name, " +
        "   p.registrationNumber, " +
        "   p.phoneNumber, " +
        "   p.email, " +
        "   p.address, " +
        "   p.zipCode, " +
        "   p.id_city, " +
        "   p.id_type_of_people, " +
        "   p.id_user, " +
        "   p.inserted_at, " +
        "   p.updated_at" +
        " from " +
        "   soulacademy.peoople p " +
        " where " +
        "   upper(p.name) like upper(%:name%) ", nativeQuery = true)
    Optional<List<People>> findByName(String name);
}
