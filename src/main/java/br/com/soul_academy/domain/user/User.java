package br.com.soul_academy.domain.user;

import br.com.soul_academy.domain.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name="user")
@Entity(name="User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;

    //Detodos implementados para login (não remover)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(getRole() != null){
            return List.of(new SimpleGrantedAuthority(role.getRole()));
        }

        return List.of(new SimpleGrantedAuthority("ROLE_USER"));

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
