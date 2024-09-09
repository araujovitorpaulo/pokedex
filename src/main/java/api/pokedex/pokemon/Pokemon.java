package api.pokedex.pokemon;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Table(name = "pokemons")
@Entity(name = "pokemons")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String number;
    private String name;
    private String type;
    private String image;

    public Pokemon (PokemonRequestDTO data){
        this.number = data.number();
        this.name = data.name();
        this.type = data.type();
        this.image = data.image();
    }

    public void editData(PokemonEditDTO data) {
        if(data.number()!=null){
            this.number = data.number();
        }
        if (data.name()!=null) {
            this.name = data.name();
        }
        if (data.type()!=null){
            this.type = data.type();
        }
        if (data.image()!=null) {
            this.image = data.image();
        }
    }

    public void delete() {

    }
}
