package galvanize.jailbook.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Post")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Category", nullable = true)
    private String category;

    @ManyToOne
    @JoinColumn(name="Criminal_ID", nullable=false)
    private Criminal criminal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Post_ID", nullable = false)
    private Integer postId;

    @Column(name = "Post_Text", nullable = false)
    private String postText;

    @Column(name = "Post_Timestamp", nullable = false)
    private LocalDateTime postTimestamp;

    @Column(name = "Upvote_Count", nullable = false)
    private Integer upvoteCount;

    @OneToMany(mappedBy="post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<CommentPost> commentPost;


    ///////////CONSTRUCTOR///////////////

    public Post() {
        this.upvoteCount = 0;
        //LocalDateTime date = new LocalDateTime();
        this.postTimestamp = LocalDateTime.now();
    }

    public Post(Criminal criminal, String postText) {

        this.criminal = criminal;
        this.postText = postText;
        this.upvoteCount = 0;
        this.postTimestamp = LocalDateTime.now();
    }

    public Post(Criminal criminal, String postText, String category) {
        this.category = category;
        this.criminal = criminal;
        this.postText = postText;
        this.upvoteCount = 0;
        this.postTimestamp = LocalDateTime.now();
    }


    ////////Gs and Ss/////////////////////

    public List<CommentPost> getCommentPost() {
        return commentPost;
    }
    //NEXT TIME I WILL USE "ADD" as the verb instead, 'set' makes not sense to me now.
    public Post setCommentPost(CommentPost commentPost) {
        this.commentPost.add(commentPost);
        return this;
    }

    public Post setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Post setCriminalId(Criminal criminal) {
        this.criminal = criminal;
        return this;
    }

    public Criminal getCriminalId() {
        return criminal;
    }

    public Post setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    public Integer getPostId() {
        return postId;
    }

    public Post setPostText(String postText) {
        this.postText = postText;
        return this;
    }

    public String getPostText() {
        return postText;
    }

    public Post setPostTimestamp(LocalDateTime postTimestamp) {
        this.postTimestamp = postTimestamp;
        return this;
    }

    public LocalDateTime getPostTimestamp() {
        return postTimestamp;
    }

    public Post setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
        return this;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    @Override
    public String toString() {
        return "Post{" +
               "category=" + category + '\'' +
               "criminalId=" + criminal + '\'' +
               "postId=" + postId + '\'' +
               "postText=" + postText + '\'' +
               "postTimestamp=" + postTimestamp + '\'' +
               "upvoteCount=" + upvoteCount + '\'' +
               '}';
    }
}
