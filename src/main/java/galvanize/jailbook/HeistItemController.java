package galvanize.jailbook;
import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.entities.HeistItem;
import galvanize.jailbook.entities.HeistPosition;
import galvanize.jailbook.repositories.HeistItemRepository;
import galvanize.jailbook.repositories.HeistPositionRepository;
import galvanize.jailbook.repositories.HeistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("latestHits/heistItem")
public class HeistItemController {

    private final HeistItemRepository heistItemRepo;

    public HeistItemController(HeistItemRepository heistItemRepo) {
        this.heistItemRepo = heistItemRepo;
    }

    @PostMapping("")
    public HeistItem create(@RequestBody HeistItem heistRole) {return this.heistItemRepo.save(heistRole);}

    @GetMapping("")
    public Iterable<HeistItem> generalizedSearch(@RequestParam HashMap<String, String> querystring) {
        if (querystring.keySet().size() == 0) {
            return this.heistItemRepo.findAll();
        } else {
            Set<HeistItem> intersection = new HashSet<HeistItem>((Collection<? extends HeistItem>) this.heistItemRepo.findAll());
            if (querystring.containsKey("heistId")) {
                intersection.retainAll((Collection<?>) this.heistItemRepo.findAllByHeistId(Integer.parseInt(querystring.get("heistId"))));
            }  if (querystring.containsKey("bringer")) {
                intersection.retainAll((Collection<?>) this.heistItemRepo.findAllByBringer(Integer.parseInt(querystring.get("bringer"))));
            }
            return intersection;
        }
    }



}
