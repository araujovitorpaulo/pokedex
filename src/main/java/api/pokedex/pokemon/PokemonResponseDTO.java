package api.pokedex.pokemon;

import java.util.UUID;

public record PokemonResponseDTO(UUID id, String number, String name, String type, String image) {
    public PokemonResponseDTO(Pokemon pokemon) {
        this(pokemon.getId(), pokemon.getNumber(), pokemon.getName(), pokemon.getType(), pokemon.getImage());
    }
}
