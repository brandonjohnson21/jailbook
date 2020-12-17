package galvanize.jailbook;

import galvanize.jailbook.entities.CommentPost;
import galvanize.jailbook.entities.Post;
import galvanize.jailbook.repositories.CommentPostRepository;
import galvanize.jailbook.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public void commentOnPost(@PathVariable int id, @RequestBody CommentPost comment){
        Optional<Post> Post = repository.findById(id);
        if (Post.isPresent()) {
            Post updatePost = Post.get();

            updatePost.setCommentPost(comment);
            repository.save(updatePost);
        }

    }
}
