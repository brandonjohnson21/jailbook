package galvanize.jailbook;

public class Commented {
    private int criminalId;
    private String commentText;
    private String postId;

    public int getCriminalId() {
        return criminalId;
    }

    public Commented setCriminalId(int criminalId) {
        this.criminalId = criminalId;
        return this;
    }

    public String getCommentText() {
        return commentText;
    }

    public Commented setCommentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    public String getPostId() {
        return postId;
    }

    public Commented setPostId(String postId) {
        this.postId = postId;
        return this;
    }
}
