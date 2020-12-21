package galvanize.jailbook;
import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.entities.HeistPosition;
import galvanize.jailbook.repositories.HeistPositionRepository;
import galvanize.jailbook.repositories.HeistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("latestHits/heistPosition")
public class HeistRoleController {
    private final HeistPositionRepository heistRoleRepo;

    public HeistRoleController(HeistPositionRepository heistRoleRepo) {
        this.heistRoleRepo = heistRoleRepo;
    }

    @GetMapping("")
    public Iterable<HeistPosition> generalizedSearch(@RequestParam HashMap<String, String> querystring) {
        if (querystring.keySet().size() == 0) {
            return this.heistRoleRepo.findAll();
        } else {
            Set<HeistPosition> intersection = new HashSet<HeistPosition>((Collection<? extends HeistPosition>) this.heistRoleRepo.findAll());
            if (querystring.containsKey("heistId")) {
                intersection.retainAll((Collection<?>) this.heistRoleRepo.findAllByHeistId(Integer.parseInt(querystring.get("heistId"))));
            }  if (querystring.containsKey("criminalId")) {
                intersection.retainAll((Collection<?>) this.heistRoleRepo.findAllByCriminalId(Integer.parseInt(querystring.get("criminalId"))));
            }
            return intersection;
        }
    }

    @PostMapping("")
    public HeistPosition create(@RequestBody HeistPosition heistRole) {return this.heistRoleRepo.save(heistRole);}

}
