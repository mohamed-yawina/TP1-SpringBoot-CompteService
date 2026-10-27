package ma.youssfi.compteservice.mappers;

import ma.youssfi.compteservice.dtos.CompteDTO;
import ma.youssfi.compteservice.entities.Compte;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {

    public CompteDTO fromCompte(Compte compte) {
        return CompteDTO.builder()
                .id(compte.getId())
                .dateCreation(compte.getDateCreation())
                .solde(compte.getSolde())
                .type(compte.getType())
                .build();
    }

    public Compte fromCompteDTO(CompteDTO dto) {
        return Compte.builder()
                .id(dto.getId())
                .dateCreation(dto.getDateCreation())
                .solde(dto.getSolde())
                .type(dto.getType())
                .build();
    }
}