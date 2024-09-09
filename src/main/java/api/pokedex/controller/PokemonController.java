package api.pokedex.controller;

import api.pokedex.pokemon.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @PostMapping("/add")
    public void addPokemon(@RequestBody PokemonRequestDTO data){
        Pokemon pokemonData = new Pokemon(data);
        repository.save(pokemonData);
    }

    @GetMapping("/list")
    public List<PokemonResponseDTO> getPokemon(){
        return repository.findAll().stream().map(PokemonResponseDTO::new).toList();
    }

    @PutMapping("/edit") @Transactional
    public void editPokemon(@RequestBody PokemonEditDTO data){
        var pokemon = repository.getReferenceById(data.id());
        pokemon.editData(data);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable UUID id){
        var pokemon = repository.getReferenceById(id);
        pokemon.delete();
    }
}
