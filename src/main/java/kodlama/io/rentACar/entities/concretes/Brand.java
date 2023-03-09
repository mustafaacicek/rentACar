package kodlama.io.rentACar.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "brands")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy ="brand")
    private List<Model> models;


}
