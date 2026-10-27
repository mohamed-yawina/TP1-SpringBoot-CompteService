package ma.youssfi.compteservice.repositories;

import ma.youssfi.compteservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@RepositoryRestResource(
        path = "comptes",
        excerptProjection = CompteRepository.CompteProjection.class
)
public interface CompteRepository
        extends JpaRepository<Compte, String> {

    @Projection(
            name = "compteProjection",
            types = Compte.class
    )
    interface CompteProjection {
        String getId();
        double getSolde();
        Date getDateCreation();
        ma.youssfi.compteservice.entities.TypeCompte getType();
    }
}