package br.com.soul_academy.repository;

import br.com.soul_academy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
