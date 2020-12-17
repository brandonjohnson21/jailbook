package galvanize.jailbook;

import galvanize.jailbook.entities.Review;
import galvanize.jailbook.repositories.ReviewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    private final ReviewRepository repository;

    public ReviewsController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Review> all() {
        return this.repository.findAll();
    }

}
