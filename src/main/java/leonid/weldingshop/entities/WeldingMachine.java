package leonid.weldingshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "weldings")
public class WeldingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int price;

    @ManyToOne
    private Gorelka gorelka;
}
