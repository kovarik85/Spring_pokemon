package hu.flowacademy.locker.demo.services;


import hu.flowacademy.locker.demo.models.Trainer;
import hu.flowacademy.locker.demo.repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void addTrainer(Trainer trainer){
        trainerRepository.save(trainer);
    }

    public Trainer findTrainerById(Long id){
        return trainerRepository.findById(id).orElseThrow(() ->new NoSuchElementException("Nincs ilyen tréner!!!"));
    }

    public List<Trainer> findallTrainers(){
        return trainerRepository.findAll();
    }

    public void update(Long id, Trainer newTrainer){
        Trainer trainer = findTrainerById(id);
        trainer.setName(newTrainer.getName());
        trainer.setGender(newTrainer.getGender());

        trainerRepository.save(trainer);
    }

    public void deleteAllTrainers(){
        trainerRepository.deleteAll();
    }

    public void deleteById(Long id){
        trainerRepository.deleteById(id);
    }


}
