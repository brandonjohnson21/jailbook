package galvanize.jailbook.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Heist")
public class Heist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Close_Timestamp")
    private LocalDateTime closeTimestamp;

    @Column(name = "Heist_Description")
    private String heistDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Heist_ID", nullable = false)
    private Integer heistId;

    @Column(name = "Location", nullable = false)
    private String location;

    @Column(name = "Mastermind", nullable = false)
    private Integer mastermind;

    @Column(name = "Score")
    private String score;

    @Column(name = "Start_Timestamp", nullable = false)
    private LocalDateTime startTimestamp;

    @Column(name = "Target")
    private String target;

    @Column(name = "Title", nullable = false)
    private String title;

    public Heist setCloseTimestamp(LocalDateTime closeTimestamp) {
        this.closeTimestamp = closeTimestamp;
        return this;
    }

    public LocalDateTime getCloseTimestamp() {
        return closeTimestamp;
    }

    public Heist setHeistDescription(String heistDescription) {
        this.heistDescription = heistDescription;
        return this;
    }

    public String getHeistDescription() {
        return heistDescription;
    }

    public Heist setHeistId(Integer heistId) {
        this.heistId = heistId;
        return this;
    }

    public Integer getHeistId() {
        return heistId;
    }

    public Heist setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Heist setMastermind(Integer mastermind) {
        this.mastermind = mastermind;
        return this;
    }

    public Integer getMastermind() {
        return mastermind;
    }

    public Heist setScore(String score) {
        this.score = score;
        return this;
    }

    public String getScore() {
        return score;
    }

    public Heist setStartTimestamp(LocalDateTime startTimestamp) {
        this.startTimestamp = startTimestamp;
        return this;
    }

    public LocalDateTime getStartTimestamp() {
        return startTimestamp;
    }

    public Heist setTarget(String target) {
        this.target = target;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public Heist setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Heist{" +
               "closeTimestamp=" + closeTimestamp + '\'' +
               "heistDescription=" + heistDescription + '\'' +
               "heistId=" + heistId + '\'' +
               "location=" + location + '\'' +
               "mastermind=" + mastermind + '\'' +
               "score=" + score + '\'' +
               "startTimestamp=" + startTimestamp + '\'' +
               "target=" + target + '\'' +
               "title=" + title + '\'' +
               '}';
    }
}
