package br.com.soul_academy.repository;

import br.com.soul_academy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

//    Optional<List<User>> findAllByIdRole(Long idRole);

    Boolean existsByLogin(String login);
}
