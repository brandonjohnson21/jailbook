package galvanize.jailbook.contollers;

import galvanize.jailbook.entities.HeistPosition;
import galvanize.jailbook.entities.Review;
import galvanize.jailbook.repositories.HeistPositionRepository;
import galvanize.jailbook.repositories.HeistRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heistpositions")
public class HeistPositionsController {
    private final HeistPositionRepository repository;

    public HeistPositionsController(HeistPositionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<HeistPosition> all() {
        return this.repository.findAll();
    }
}
