package br.com.soul_academy.service.user;

import br.com.soul_academy.domain.user.User;
import br.com.soul_academy.http.dto.request.UpdateUserRequest;
import br.com.soul_academy.repository.RoleRepository;
import br.com.soul_academy.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;

    public User execute(UpdateUserRequest request) {
        var user = repository.findById(request.getId())
                .orElseThrow(() -> new NoResultException("Usuário não localizado."));

        var role = roleRepository.findById(request.getIdRole())
                .orElseThrow(() -> new NoResultException("Role não localizada."));

        user.setPassword(request.getPassword());
        user.setRole(role);
        user = repository.save(user);

        return user;
    }
}
