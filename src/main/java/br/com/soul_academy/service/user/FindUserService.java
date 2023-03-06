package br.com.soul_academy.service.user;

import br.com.soul_academy.domain.user.User;
import br.com.soul_academy.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUserService {
    private final UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoResultException("Usuário não localizado."));
    }

    public User findByLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(() -> new NoResultException("Usuário não localizado."));
    }

//    public List<User> findAllByRole(Long idRole) {
//        return repository.findAllByIdRole(idRole)
//                .orElseThrow(() -> new NoResultException("Usuário não localizado."));
//    }
}
