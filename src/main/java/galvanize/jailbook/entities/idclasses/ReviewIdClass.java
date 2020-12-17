package galvanize.jailbook.entities.idclasses;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ReviewIdClass implements Serializable {
    private Integer heistId;
    private Integer reviewee;
    private Integer reviewer;

    public Integer getHeistId() {
        return heistId;
    }

    public void setHeistId(Integer heistId) {
        this.heistId = heistId;
    }

    public Integer getReviewee() {
        return reviewee;
    }

    public void setReviewee(Integer reviewee) {
        this.reviewee = reviewee;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }
}
