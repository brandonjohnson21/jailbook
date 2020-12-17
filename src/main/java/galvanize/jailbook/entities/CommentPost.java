package galvanize.jailbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment_Post")

public class CommentPost implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Comment_Post_ID")
    private Integer commentPostId;

    @Column(name = "Comment_Text", nullable = false)
    private String commentText;

    @Column(name = "Comment_Timestamp", nullable = false)
    private LocalDateTime commentTimestamp;

    @Column(name = "Criminal_ID", nullable = false)
    private Integer criminalId;

    @Column(name = "Upvote_Count", nullable = false)
    private Integer upvoteCount;

    @ManyToOne
    @JoinColumn(name="post_id")
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Post post;

    //////////CONSTRUCTORS////////////


    public CommentPost() {
        this.upvoteCount = 0;
        this.commentTimestamp = LocalDateTime.now();
    }

    public CommentPost(Integer criminalId, String commentText, Post post) {
        this.commentText = commentText;
        this.criminalId = criminalId;
        this.upvoteCount = 0;
        this.commentTimestamp = LocalDateTime.now();
        this.post = post;
    }

    ////////Gs and Ss/////////////////////


    public Post getPost() {
        return post;
    }

    public CommentPost setPost(Post post) {
        this.post = post;
        return this;
    }

    public CommentPost setCommentPostId(Integer commentPostId) {
        this.commentPostId = commentPostId;
        return this;
    }

    public Integer getCommentPostId() {
        return commentPostId;
    }

    public CommentPost setCommentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    public String getCommentText() {
        return commentText;
    }

    public CommentPost setCommentTimestamp(LocalDateTime commentTimestamp) {
        this.commentTimestamp = commentTimestamp;
        return this;
    }

    public LocalDateTime getCommentTimestamp() {
        return commentTimestamp;
    }

    public CommentPost setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
        return this;
    }

    public Integer getCriminalId() {
        return criminalId;
    }


    public CommentPost setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
        return this;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    @Override
    public String toString() {
        return "CommentPost{" +
               "commentPostId=" + commentPostId + '\'' +
               "commentText=" + commentText + '\'' +
               "commentTimestamp=" + commentTimestamp + '\'' +
               "criminalId=" + criminalId + '\'' +
               "upvoteCount=" + upvoteCount + '\'' +
               '}';
    }
}
