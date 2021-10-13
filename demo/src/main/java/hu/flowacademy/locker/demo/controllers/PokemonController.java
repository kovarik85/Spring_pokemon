package hu.flowacademy.locker.demo.controllers;

import hu.flowacademy.locker.demo.models.Pokemon;
import hu.flowacademy.locker.demo.services.PokemonService;
import hu.flowacademy.locker.demo.services.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon")
public class PokemonController {

        private final PokemonService pokemonService;


    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;

    }

    @PostMapping("/")
    public String addPokemon(@RequestBody Pokemon pokemon){
        pokemonService.addPokemon(pokemon);
       return "Pokemon added!";
    }

    @PutMapping("/{id}")
    public void replacePokemonById(@PathVariable Long id, @RequestBody Pokemon pokemon){
        pokemonService.update(id, pokemon);
    }

    @GetMapping("/")
    public List<Pokemon> allPokemons(){
       return pokemonService.allPokemons();
    }

    @GetMapping("/{id}")
    public Pokemon findById(@PathVariable Long id){
       return pokemonService.findPokemonById(id);
    }


    @DeleteMapping("/")
    public void deleteAll(){
        pokemonService.deleteAllPokmeons();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        pokemonService.deleteById(id);
    }



}
