package galvanize.jailbook.contollers;

import galvanize.jailbook.entities.Criminal;
import galvanize.jailbook.entities.Review;
import galvanize.jailbook.repositories.CriminalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/criminals")
public class CriminalsController {

    private final CriminalRepository repository;

    public CriminalsController(CriminalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Criminal> all() {
        return this.repository.findAll();
    }
}
