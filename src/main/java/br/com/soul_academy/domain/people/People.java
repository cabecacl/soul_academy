package br.com.soul_academy.domain.people;

import br.com.soul_academy.domain.Address.City;
import br.com.soul_academy.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="people")
@Entity(name="Peole")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String registrationNumber;
    private String phoneNumber;
    private String email;
    private String address;
    private String zipCode;

    @JoinColumn(name = "id_city")
    @ManyToOne(optional = false)
    private City city;

    @JoinColumn(name = "id_type_of_people")
    @ManyToOne(optional = false)
    private TypeOfPeople typeOfPeople;

    @JoinColumn(name = "id_user")
    @OneToOne(optional = false)
    private User user;

    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

}
