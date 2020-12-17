package galvanize.jailbook.entities;

import galvanize.jailbook.entities.idclasses.ReviewIdClass;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Review")
@IdClass(ReviewIdClass.class)
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Heist_ID", nullable = false)
    private Integer heistId;

    @Column(name = "Review_Rating", nullable = false)
    private Float reviewRating;

    @Column(name = "Review_Text")
    private String reviewText;

    @Id
    @Column(name = "Reviewee", nullable = false)
    private Integer reviewee;

    @Id
    @Column(name = "Reviewer", nullable = false)
    private Integer reviewer;

    public Review setHeistId(Integer heistId) {
        this.heistId = heistId;
        return this;
    }

    public Integer getHeistId() {
        return heistId;
    }

    public Review setReviewRating(Float reviewRating) {
        this.reviewRating = reviewRating;
        return this;
    }

    public Float getReviewRating() {
        return reviewRating;
    }

    public Review setReviewText(String reviewText) {
        this.reviewText = reviewText;
        return this;
    }

    public String getReviewText() {
        return reviewText;
    }

    public Review setReviewee(Integer reviewee) {
        this.reviewee = reviewee;
        return this;
    }

    public Integer getReviewee() {
        return reviewee;
    }

    public Review setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    @Override
    public String toString() {
        return "Review{" +
               "heistId=" + heistId + '\'' +
               "reviewRating=" + reviewRating + '\'' +
               "reviewText=" + reviewText + '\'' +
               "reviewee=" + reviewee + '\'' +
               "reviewer=" + reviewer + '\'' +
               '}';
    }
}
