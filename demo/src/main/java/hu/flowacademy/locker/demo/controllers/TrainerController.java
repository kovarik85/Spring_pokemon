package hu.flowacademy.locker.demo.controllers;

import hu.flowacademy.locker.demo.models.Trainer;
import hu.flowacademy.locker.demo.services.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/")
    public String addPokemon(@RequestBody Trainer trainer){
        trainerService.addTrainer(trainer);
        return "Trainer added!";
    }

    @PutMapping("/{id}")
    public void replacePokemonById(@PathVariable Long id, @RequestBody Trainer trainer ){
        trainerService.update(id, trainer);
    }

    @GetMapping("/")
    public List<Trainer> allPokemons(){
        return trainerService.findallTrainers();
    }

    @GetMapping("/{id}")
    public Trainer findById(@PathVariable Long id){
        return trainerService.findTrainerById(id);
    }

    @DeleteMapping("/")
    public void deleteAll(){
        trainerService.deleteAllTrainers();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        trainerService.deleteById(id);
    }


}
