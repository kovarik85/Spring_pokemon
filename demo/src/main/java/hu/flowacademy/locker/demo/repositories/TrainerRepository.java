package hu.flowacademy.locker.demo.repositories;

import hu.flowacademy.locker.demo.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Optional<Trainer> findById(Long id);
    List<Trainer> findAll();

}
