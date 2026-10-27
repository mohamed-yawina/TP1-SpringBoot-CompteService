package ma.youssfi.compteservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ma.youssfi.compteservice.entities.TypeCompte;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteDTO {

    private String id;

    private Date dateCreation;

    private double solde;

    private TypeCompte type;
}