package ma.youssfi.compteservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    private double solde;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}