package hu.flowacademy.locker.demo.models;

import com.sun.istack.NotNull;
import hu.flowacademy.locker.demo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Pokemon.class)
    private List<Pokemon> pokemonList;
}
