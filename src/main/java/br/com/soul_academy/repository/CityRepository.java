package br.com.soul_academy.repository;

import br.com.soul_academy.domain.Address.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
