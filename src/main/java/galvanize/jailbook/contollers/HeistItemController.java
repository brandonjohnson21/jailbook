package galvanize.jailbook.contollers;

import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.entities.HeistItem;
import galvanize.jailbook.repositories.HeistItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heistitems")
public class HeistItemController {

    private final HeistItemRepository repository;

    public HeistItemController(HeistItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<HeistItem> all() {
        return this.repository.findAll();
    }
}
