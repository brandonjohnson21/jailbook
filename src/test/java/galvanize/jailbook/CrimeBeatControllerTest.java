package galvanize.jailbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import galvanize.jailbook.entities.CommentPost;
import galvanize.jailbook.entities.Post;
import galvanize.jailbook.repositories.CommentPostRepository;
import galvanize.jailbook.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CrimeBeatControllerTest {

    ObjectMapper objMap = new ObjectMapper();
    MockHttpServletRequestBuilder req;
    //will set this so I have a usable msgID for tests as the database increments its indexes
    int msgID;
    //used for testing Beat responses
    Post testPost = new Post();

    @Autowired
    MockMvc mvc;
    @Autowired
    PostRepository repository;
    @Autowired
    CommentPostRepository commentRepo;

    @BeforeEach
    @Transactional
    @Rollback
    void init() throws JsonProcessingException {
    //Seed data

        repository.save(new Post(1,"evilCorp hacked again....","Hackathon"));
        repository.save(new Post(2,"Fun outing last night at the Wells Fargo!"));
        repository.save(new Post(6,"Looking for something to murder..?"));
        System.out.print("Global Ids used for this test: ");
        this.repository.findAll().forEach(x -> System.out.print(+x.getPostId()+ ", "));

        Iterable<Post> records = this.repository.findAll();
        if (records.iterator().hasNext()) msgID = records.iterator().next().getPostId();
        System.out.println("\n using this id for this test: "+msgID);

    }

    //Get news feed items

    @Test
    @Transactional
    @Rollback
    public void getNewsFeedItems() throws Exception {
        req = get("/beat/feed")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]postId", instanceOf(Number.class)))
                .andExpect(jsonPath("$.[0]criminalId", equalTo(1)))
                .andExpect(jsonPath("$.[0]postText", equalTo("evilCorp hacked again....")))
                .andExpect(jsonPath("$.[0]category", equalTo("Hackathon")))
                .andExpect(jsonPath("$.[1]postId", instanceOf(Number.class)))
                .andExpect(jsonPath("$.[1]criminalId", equalTo(2)))
                .andExpect(jsonPath("$.[1]postText", equalTo("Fun outing last night at the Wells Fargo!")))
                .andExpect(jsonPath("$.[2]postId", instanceOf(Number.class)))
                .andExpect(jsonPath("$.[2]criminalId", equalTo(6)))
                .andExpect(jsonPath("$.[2]postText", equalTo("Looking for something to murder..?")));

    }

    //Ability to post new news feed items
    @Test
    @Transactional
    @Rollback
    public void postNewsFeedItem() throws Exception {

        HashMap<String, Object> newPost = new HashMap<String, Object>(){
            {
                put("criminalId","10");
                put("postText","The cops are blockin' again");
            }
        };

        String json = objMap.writeValueAsString(newPost);

        req = post("/beat/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postId", instanceOf(Number.class)))
                .andExpect(jsonPath("$.criminalId", equalTo(10)))
                .andExpect(jsonPath("$.postText", equalTo("The cops are blockin' again")));



    }
    //Ability to categorize new news feed items
    @Test
    @Transactional
    @Rollback
    public void categorizePostedNewsItem() throws Exception {

        HashMap<String, Object> newPost = new HashMap<String, Object>(){
            {
                put("criminalId","666");
                put("postText","Protest happening tonight against protesting! All Call for some serious looting!");
                put("category","Protest");
            }
        };

        String json = objMap.writeValueAsString(newPost);

        req = post("/beat/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postId", instanceOf(Number.class)))
                .andExpect(jsonPath("$.criminalId", equalTo(666)))
                .andExpect(jsonPath("$.postText", equalTo("Protest happening tonight against protesting! All Call for some serious looting!")))
                .andExpect(jsonPath("$.category", equalTo("Protest")));
    }
    //Ability to upvote a news feed item
    @Test
    @Transactional
    @Rollback
    public void upVoteNewsItem() throws Exception {

        req = post("/beat/upvote/"+msgID)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk());

        Optional<Post> upvoteTest = this.repository.findById(msgID);

        upvoteTest.ifPresent(post -> testPost = post);
        assertEquals(1,testPost.getUpvoteCount(),"upvotes for post was supposed to equal 1 but did not");

    }
    //comment on news feed items
    @Test
    @Transactional
    @Rollback
    public void leaveCommentOnNewsItem() throws Exception {

        HashMap<String, Object> newComment = new HashMap<String, Object>(){
            {
                put("criminalId","666");
                put("commentText","This was the most fun I've had since I road in the smart car getaway vehicle with the idiot");
            }
        };
        String json = objMap.writeValueAsString(newComment);
        req = post("/beat/comment/"+msgID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk());

        Iterable<CommentPost> commentTest = this.commentRepo.findAll();
        assertEquals("This was the most fun I've had since I road in the smart car getaway vehicle with the idiot",
                        commentTest.iterator().next().getCommentText(),"expected comment to match but did not");



    }
    //find latest nefarious events to cash in on
    @Test
    @Transactional
    @Rollback
    public void getNefariousItems() throws Exception {

        repository.save(new Post(666,"Protest happening tonight against protesting! All Call for some serious looting!","Protest"));


        req = get("/beat/nefarious")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]postId", instanceOf(Number.class)))
                .andExpect(jsonPath("$.[0]criminalId", equalTo(1)))
                .andExpect(jsonPath("$.[0]postText", equalTo("evilCorp hacked again....")))
                .andExpect(jsonPath("$.[0]category", equalTo("Hackathon")))
                .andExpect(jsonPath("$.[1]postId", instanceOf(Number.class)))
                .andExpect(jsonPath("$.[1]criminalId", equalTo(666)))
                .andExpect(jsonPath("$.[1]postText", equalTo("Protest happening tonight against protesting! All Call for some serious looting!")))
                .andExpect(jsonPath("$.[1]category", equalTo("Protest")))
                .andExpect(jsonPath("$",hasSize(2)));

    }

    //Comments Viewable on post
    @Test
//    @Transactional
//    @Rollback
    public void canSeeCommentsOnPost() throws Exception {
        Optional<Post> postGetter = repository.findById(msgID);

        if (postGetter.isPresent()) {
            Post updatePost = postGetter.get();
            CommentPost comment = new CommentPost(666,"This was the most fun I've had since I road in the smart car getaway vehicle with the idiot",updatePost);
            comment.setPost(updatePost);
            comment = commentRepo.save(comment);

            updatePost.setCommentPost(comment);
            repository.save(updatePost);
        }

        req = get("/beat/feed")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]commentPost",hasSize(1)));
                //.andExpect(jsonPath($.));


    }

}
