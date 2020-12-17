package galvanize.jailbook.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Category", nullable = false)
    private String category;

    @Column(name = "Criminal_ID", nullable = false)
    private Integer criminalId;

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

    public Post setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Post setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
        return this;
    }

    public Integer getCriminalId() {
        return criminalId;
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
               "criminalId=" + criminalId + '\'' +
               "postId=" + postId + '\'' +
               "postText=" + postText + '\'' +
               "postTimestamp=" + postTimestamp + '\'' +
               "upvoteCount=" + upvoteCount + '\'' +
               '}';
    }
}
