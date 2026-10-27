package ma.youssfi.compteservice.services;

import lombok.RequiredArgsConstructor;
import ma.youssfi.compteservice.dtos.CompteDTO;
import ma.youssfi.compteservice.entities.Compte;
import ma.youssfi.compteservice.mappers.CompteMapper;
import ma.youssfi.compteservice.repositories.CompteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompteDTO> getAllComptes() {
        return compteRepository.findAll()
                .stream()
                .map(compteMapper::fromCompte)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CompteDTO getCompteById(String id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Compte introuvable : " + id
                ));

        return compteMapper.fromCompte(compte);
    }

    @Override
    public CompteDTO saveCompte(CompteDTO compteDTO) {

        validateCompte(compteDTO);

        Compte compte = compteMapper.fromCompteDTO(compteDTO);

        compte.setId(null);

        if (compte.getDateCreation() == null) {
            compte.setDateCreation(new Date());
        }

        Compte saved = compteRepository.save(compte);

        return compteMapper.fromCompte(saved);
    }

    @Override
    public CompteDTO updateCompte(String id, CompteDTO dto) {

        validateCompte(dto);

        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Compte introuvable : " + id
                ));

        compte.setSolde(dto.getSolde());
        compte.setType(dto.getType());

        Compte updated = compteRepository.save(compte);

        return compteMapper.fromCompte(updated);
    }

    @Override
    public void deleteCompte(String id) {

        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Compte introuvable : " + id
                ));

        compteRepository.delete(compte);
    }

    private void validateCompte(CompteDTO dto) {

        if (dto == null || dto.getType() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le type du compte est obligatoire"
            );
        }

        if (!Double.isFinite(dto.getSolde())
                || dto.getSolde() < 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le solde doit être un nombre positif ou nul"
            );
        }
    }
}