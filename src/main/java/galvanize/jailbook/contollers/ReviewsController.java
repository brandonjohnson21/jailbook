package galvanize.jailbook.contollers;

import galvanize.jailbook.entities.Review;
import galvanize.jailbook.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private final ReviewRepository repository;

    public ReviewsController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Review> all() {
        return this.repository.findAll();
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addReview(@RequestBody Review review) {
        repository.save(review);
    }
}
