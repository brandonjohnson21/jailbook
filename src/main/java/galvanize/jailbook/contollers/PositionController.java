package galvanize.jailbook.contollers;

import galvanize.jailbook.entities.Position;
import galvanize.jailbook.repositories.PositionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionRepository repository;

    public PositionController(PositionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Position> all() {
        return this.repository.findAll();
    }
}
