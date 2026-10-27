package ma.youssfi.compteservice.services;

import ma.youssfi.compteservice.dtos.CompteDTO;

import java.util.List;

public interface CompteService {

    List<CompteDTO> getAllComptes();

    CompteDTO getCompteById(String id);

    CompteDTO saveCompte(CompteDTO compteDTO);

    CompteDTO updateCompte(String id, CompteDTO compteDTO);

    void deleteCompte(String id);
}