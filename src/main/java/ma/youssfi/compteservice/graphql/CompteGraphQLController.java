package ma.youssfi.compteservice.graphql;

import lombok.RequiredArgsConstructor;
import ma.youssfi.compteservice.dtos.CompteDTO;
import ma.youssfi.compteservice.entities.TypeCompte;
import ma.youssfi.compteservice.services.CompteService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompteGraphQLController {

    private final CompteService compteService;

    @QueryMapping
    public List<CompteDTO> allComptes() {
        return compteService.getAllComptes();
    }

    @QueryMapping
    public CompteDTO compteById(@Argument("id") String id) {
        return compteService.getCompteById(id);
    }

    @MutationMapping
    public CompteDTO addCompte(
            @Argument("solde") double solde,
            @Argument("type") TypeCompte type) {

        CompteDTO dto = CompteDTO.builder()
                .solde(solde)
                .type(type)
                .build();

        return compteService.saveCompte(dto);
    }

    @MutationMapping
    public CompteDTO updateCompte(
            @Argument("id") String id,
            @Argument("solde") double solde,
            @Argument("type") TypeCompte type) {

        CompteDTO dto = CompteDTO.builder()
                .solde(solde)
                .type(type)
                .build();

        return compteService.updateCompte(id, dto);
    }

    @MutationMapping
    public boolean deleteCompte(@Argument("id") String id) {
        compteService.deleteCompte(id);
        return true;
    }
}