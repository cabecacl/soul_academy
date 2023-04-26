package br.com.soul_academy.service.user;

import br.com.soul_academy.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserService {
    private final UserRepository repository;

    public void delete(Long id) {
        var user = repository.findById(id)
                .orElseThrow(() -> new NoResultException("Usuário não localizado."));

        repository.delete(user);
    }

    public void deleteByLogin(String login) {
        var user = repository.findByLogin(login)
                .orElseThrow(() -> new NoResultException("Usuário não localizado."));

        repository.delete(user);
    }
}
