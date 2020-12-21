package galvanize.jailbook;

public class Posted {
    private int criminalId;
    private String postText;
    private String category;

    public Posted() {
    }

    public int getCriminalId() {
        return criminalId;
    }

    public Posted setCriminalId(int criminalId) {
        this.criminalId = criminalId;
        return this;
    }

    public String getPostText() {
        return postText;
    }

    public Posted setPostText(String postText) {
        this.postText = postText;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Posted setCategory(String category) {
        this.category = category;
        return this;
    }
}
