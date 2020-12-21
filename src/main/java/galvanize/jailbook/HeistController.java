package galvanize.jailbook;

import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.repositories.HeistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("latestHits/heist")
public class HeistController {

    private final HeistRepository heistRepo;

    public HeistController(HeistRepository heistRepo) {
        this.heistRepo = heistRepo;
    }

    @GetMapping("")
    public Iterable<Heist> generalizedSearch(@RequestParam HashMap<String, String> querystring) {
        if(querystring.keySet().size() == 0){
            return this.heistRepo.findAll();
        } else {
            Set<Heist> intersection = new HashSet<Heist>((Collection<? extends Heist>) this.heistRepo.findAll());
            if(querystring.containsKey("mastermind")) {
                intersection.retainAll((Collection<?>) this.heistRepo.findAllByMastermind(Integer.parseInt(querystring.get("mastermind"))));
            }if(querystring.containsKey("location")) {
                intersection.retainAll((Collection<?>) this.heistRepo.findAllByLocationContaining(querystring.get("location")));
            }if(querystring.containsKey("heistDescription")) {
                intersection.retainAll((Collection<?>) this.heistRepo.findAllByHeistDescriptionContaining(querystring.get("heistDescription")));
            }if(querystring.containsKey("heistId")) {
                intersection.retainAll((Collection<?>) this.heistRepo.findByHeistId(Integer.parseInt(querystring.get("heistId"))));
            }if(querystring.containsKey("score")) {
                intersection.retainAll((Collection<?>) this.heistRepo.findAllByScoreContaining(querystring.get("score")));
            }if(querystring.containsKey("title")) {
                intersection.retainAll((Collection<?>) this.heistRepo.findAllByTitleContaining(querystring.get("title")));
            }if(querystring.containsKey("target")) {
                intersection.retainAll((Collection<?>) this.heistRepo.findAllByTargetContaining(querystring.get("target")));
            }
            return intersection;
        }
    }
    @PostMapping("")
    public Heist create(@RequestBody Heist heist) {
        return this.heistRepo.save(heist);
    }

    @PutMapping("")
    public Heist put(@RequestBody Heist heist) {
        return this.heistRepo.save(heist);
    }

    @PatchMapping("")
    public Heist patch(@RequestBody Heist heist) {
        return this.heistRepo.save(heist);
    }

    @DeleteMapping("")
    public Heist del(@RequestBody Heist heist) {
        return this.heistRepo.save(heist);
    }


    @GetMapping("/{id}")
    public Heist getByID(@PathVariable Integer id){
        return this.heistRepo.findByHeistId(id);
    }



}