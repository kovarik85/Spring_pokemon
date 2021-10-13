package hu.flowacademy.locker.demo.repositories;

import hu.flowacademy.locker.demo.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findAll();
    Optional<Pokemon> findById(Long id);



}
