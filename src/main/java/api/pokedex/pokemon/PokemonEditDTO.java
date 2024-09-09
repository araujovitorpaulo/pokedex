package api.pokedex.pokemon;

import java.util.UUID;

public record PokemonEditDTO(UUID id, String number, String name, String type, String image) {

}
