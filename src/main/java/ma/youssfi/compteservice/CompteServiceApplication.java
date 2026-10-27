package ma.youssfi.compteservice;

import ma.youssfi.compteservice.entities.Compte;
import ma.youssfi.compteservice.entities.TypeCompte;
import ma.youssfi.compteservice.repositories.CompteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				CompteServiceApplication.class, args
		);
	}

	@Bean
	CommandLineRunner start(CompteRepository repository) {
		return args -> {

			for (int i = 0; i < 10; i++) {

				Compte compte = Compte.builder()
						.dateCreation(new Date())
						.solde(1000 + Math.random() * 90000)
						.type(i % 2 == 0
								? TypeCompte.COURANT
								: TypeCompte.EPARGNE)
						.build();

				repository.save(compte);
			}

			System.out.println("===== COMPTES BANCAIRES =====");

			repository.findAll()
					.forEach(System.out::println);
		};
	}
}