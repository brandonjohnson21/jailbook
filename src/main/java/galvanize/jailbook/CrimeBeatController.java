package galvanize.jailbook;

import galvanize.jailbook.entities.CommentPost;
import galvanize.jailbook.entities.Criminal;
import galvanize.jailbook.entities.Post;
import galvanize.jailbook.repositories.CommentPostRepository;
import galvanize.jailbook.repositories.CriminalRepository;
import galvanize.jailbook.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:6530")
@RestController
public class CrimeBeatController {
    @Autowired
    PostRepository repository;
    @Autowired
    CommentPostRepository commentRepo;
    @Autowired
    CriminalRepository crimeRepo;

   @GetMapping("/beat/feed")
    public Iterable<Post> getBeats(){
         return this.repository.findAll();
    }

    @PostMapping("/beat/new")
    public Post postBeat(@RequestBody Posted post){
      Optional<Criminal> postedBy =  crimeRepo.findById(post.getCriminalId());
      Post msgPost = new Post();

      postedBy.ifPresent(x -> { msgPost.setCriminalId(x);
        msgPost.setPostText(post.getPostText());
        msgPost.setCategory(post.getCategory());
        });

        return this.repository.save(msgPost);
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

    @PostMapping("/beat/downvote/{id}")
    public Post downVotePost(@PathVariable int id){
        Optional<Post> Post = repository.findById(id);

        if ( Post.isPresent()) {

            Post updatePost = Post.get();
            updatePost.setUpvoteCount(updatePost.getUpvoteCount()-1);
            return repository.save(updatePost);
        }
        else return new Post();
    }

    @GetMapping("/beat/nefarious")
    public Iterable<Post> getNefarious(){
        return repository.findByCategoryNotNull();
    }

    @PostMapping("/beat/comment/{id}")
    public Post commentOnPost(@PathVariable int id, @RequestBody Commented newComment){

        Optional<Criminal> commentedBy =  crimeRepo.findById(newComment.getCriminalId());

        CommentPost msgComment = new CommentPost();

        Optional<Post> post = repository.findById(id);

        if (post.isPresent() && commentedBy.isPresent()){
            msgComment.setCriminalId(commentedBy.get());
            msgComment.setCommentText(newComment.getCommentText());
            msgComment.setPost(post.get());
            return repository.save(post.get().setCommentPost(msgComment));
        }
        return new Post();

    }
}
