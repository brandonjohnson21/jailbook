package galvanize.jailbook.contollers;

import galvanize.jailbook.entities.Criminal;
import galvanize.jailbook.entities.CriminalPosition;
import galvanize.jailbook.repositories.CriminalPositionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/criminalpositions")
public class CriminalPositionController {

    private final CriminalPositionRepository repository;

    public CriminalPositionController(CriminalPositionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<CriminalPosition> all() {
        return this.repository.findAll();
    }
}
