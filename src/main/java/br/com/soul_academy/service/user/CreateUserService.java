package br.com.soul_academy.service.user;

import br.com.soul_academy.domain.user.User;
import br.com.soul_academy.http.dto.request.CreateUserRequest;
import br.com.soul_academy.infra.exception.DataAlreadyRegisteredException;
import br.com.soul_academy.repository.RoleRepository;
import br.com.soul_academy.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;

    public User execute(CreateUserRequest request) {
        var role = roleRepository.findById(request.getIdRole())
                .orElseThrow(() -> new NoResultException("Role não localizada."));

        validateUserThrowsException(request);

        var user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        user.setRole(role);
        user = repository.save(user);
        return user;
    }

    private void validateUserThrowsException(CreateUserRequest request) {
        validateLogin(request.getLogin());
    }

    private void validateLogin(String login) {
        if(repository.existsByLogin(login)) {
            throw new DataAlreadyRegisteredException("Login já existente.");
        }
    }
}
