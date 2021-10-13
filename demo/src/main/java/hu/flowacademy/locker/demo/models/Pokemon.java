package hu.flowacademy.locker.demo.models;


import com.sun.istack.NotNull;
import hu.flowacademy.locker.demo.enums.Species;
import hu.flowacademy.locker.demo.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "species", nullable = false)
    private Species species;

    @Column(name = "type", nullable = false)
    private Type type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;
}
