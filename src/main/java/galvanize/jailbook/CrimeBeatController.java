package galvanize.jailbook;

import galvanize.jailbook.entities.CommentPost;
import galvanize.jailbook.entities.Post;
import galvanize.jailbook.repositories.CommentPostRepository;
import galvanize.jailbook.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:6530")
@RestController
public class CrimeBeatController {
    @Autowired
    PostRepository repository;
    @Autowired
    CommentPostRepository commentRepo;

   @GetMapping("/beat/feed")
    public Iterable<Post> getBeats(){
         return this.repository.findAll();
    }

    @PostMapping("/beat/new")
    public Post postBeat(@RequestBody Post post){

        return this.repository.save(post);
    }
    @PostMapping("/beat/upvote/{id}")
    public Post upVotePost(@PathVariable int id){
        Optional<Post> Post = repository.findById(id);

        if ( Post.isPresent()) {

            Post updatePost = Post.get();
            updatePost.setUpvoteCount(updatePost.getUpvoteCount()+1);
            return repository.save(updatePost);
        }
        else return new Post();
    }

    @GetMapping("/beat/nefarious")
    public Iterable<Post> getNefarious(){
        return repository.findByCategoryNotNull();
    }

    @PostMapping("/beat/comment/{id}")
    public Post commentOnPost(@PathVariable int id, @RequestBody CommentPost comment){
        Optional<Post> post = repository.findById(id);

        if (post.isPresent()) {
            Post updatePost = post.get();
            comment.setPost(updatePost);

            updatePost.setCommentPost(comment);
            return repository.save(updatePost);
        }
        return new Post();

    }
}
