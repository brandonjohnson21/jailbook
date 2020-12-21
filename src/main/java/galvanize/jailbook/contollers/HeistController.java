package galvanize.jailbook.contollers;

import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.repositories.HeistRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heists")
public class HeistController {

    private final HeistRepository repository;

    public HeistController(HeistRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Heist> all() {
        return this.repository.findAll();
    }
}
