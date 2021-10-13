package hu.flowacademy.locker.demo.services;

import hu.flowacademy.locker.demo.models.Pokemon;
import hu.flowacademy.locker.demo.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public void addPokemon(Pokemon pokemon){
        pokemonRepository.save(pokemon);
    }

    public Pokemon findPokemonById(Long id){
        return pokemonRepository.findById(id).orElseThrow(() ->new NoSuchElementException("Nincs ilyen pokemon!!!"));
    }
    public void update(Long id, Pokemon newPokemon){
        Pokemon pokemon = findPokemonById(id);
        pokemon.setSpecies(newPokemon.getSpecies());
        pokemon.setNickName(newPokemon.getNickName());
        pokemon.setType(newPokemon.getType());

        pokemonRepository.save(pokemon);
}

    public List<Pokemon> allPokemons(){
       return pokemonRepository.findAll();
    }

    public void deleteById(Long id){
        pokemonRepository.deleteById(id);
    }

    public void deleteAllPokmeons(){
        pokemonRepository.deleteAll();
    }

}
