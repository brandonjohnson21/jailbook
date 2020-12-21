package galvanize.jailbook;

import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.entities.HeistPosition;
import galvanize.jailbook.entities.Position;
import galvanize.jailbook.repositories.HeistPositionRepository;
import galvanize.jailbook.repositories.HeistRepository;
import galvanize.jailbook.repositories.PositionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("latestHits/position")
public class HeistPositionController {

    private final PositionRepository positionRepo;

    public HeistPositionController(PositionRepository positionRepo) {
        this.positionRepo = positionRepo;
    }

    @GetMapping("")
    public Iterable<Position> generalizedSearch(@RequestParam HashMap<String, String> querystring) {
        if (querystring.keySet().size() == 0) {
            return this.positionRepo.findAll();
        } else {
            Set<Position> intersection = new HashSet<Position>((Collection<? extends Position>) this.positionRepo.findAll());
            if (querystring.containsKey("positionName")) {
                intersection.retainAll((Collection<?>) this.positionRepo.findAllByPositionNameContaining((querystring.get("positionName"))));
            }  if (querystring.containsKey("positionDescription")) {
                intersection.retainAll((Collection<?>) this.positionRepo.findAllByPositionDescriptionContaining((querystring.get("positionDescription"))));
            }
            return intersection;
        }
    }

    @GetMapping("/{id}")
    public Position getByID(@PathVariable Integer id){
        return this.positionRepo.findByPositionId(id);
    }


    @PostMapping("")
    public Position create(@RequestBody Position heistRole) {return this.positionRepo.save(heistRole);}

    @PatchMapping("")
    public Position patch(@RequestBody Position heistRole) {return this.positionRepo.save(heistRole);}

    @PutMapping("")
    public Position put(@RequestBody Position heistRole) {return this.positionRepo.save(heistRole);}

}
