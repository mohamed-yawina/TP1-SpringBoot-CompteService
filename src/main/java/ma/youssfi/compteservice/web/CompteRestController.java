package ma.youssfi.compteservice.web;

import lombok.RequiredArgsConstructor;
import ma.youssfi.compteservice.dtos.CompteDTO;
import ma.youssfi.compteservice.services.CompteService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
public class CompteRestController {

    private final CompteService compteService;

    @GetMapping
    public List<CompteDTO> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public CompteDTO getCompte(@PathVariable String id) {
        return compteService.getCompteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompteDTO saveCompte(@RequestBody CompteDTO dto) {
        return compteService.saveCompte(dto);
    }

    @PutMapping("/{id}")
    public CompteDTO updateCompte(
            @PathVariable String id,
            @RequestBody CompteDTO dto) {

        return compteService.updateCompte(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompte(@PathVariable String id) {
        compteService.deleteCompte(id);
    }
}