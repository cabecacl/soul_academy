package br.com.soul_academy.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
