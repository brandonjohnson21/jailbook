package galvanize.jailbook.entities;

import galvanize.jailbook.entities.idclasses.HeistPositionIdClass;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Heist_Position")
@IdClass(HeistPositionIdClass.class)
public class HeistPosition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Criminal_ID", nullable = false)
    private Integer criminalId;

    @Id
    @Column(name = "Heist_ID", nullable = false)
    private Integer heistId;

    @Column(name = "Maximum_Rating")
    private Float maximumRating;

    @Column(name = "Maximum_Skill_Level")
    private Integer maximumSkillLevel;

    @Column(name = "Minimum_Rating")
    private Float minimumRating;

    @Column(name = "Minimum_Skill_Level")
    private Integer minimumSkillLevel;

    @Id
    @Column(name = "Position_ID", nullable = false)
    private Integer positionId;

    public HeistPosition setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
        return this;
    }

    public Integer getCriminalId() {
        return criminalId;
    }

    public HeistPosition setHeistId(Integer heistId) {
        this.heistId = heistId;
        return this;
    }

    public Integer getHeistId() {
        return heistId;
    }

    public HeistPosition setMaximumRating(Float maximumRating) {
        this.maximumRating = maximumRating;
        return this;
    }

    public Float getMaximumRating() {
        return maximumRating;
    }

    public HeistPosition setMaximumSkillLevel(Integer maximumSkillLevel) {
        this.maximumSkillLevel = maximumSkillLevel;
        return this;
    }

    public Integer getMaximumSkillLevel() {
        return maximumSkillLevel;
    }

    public HeistPosition setMinimumRating(Float minimumRating) {
        this.minimumRating = minimumRating;
        return this;
    }

    public Float getMinimumRating() {
        return minimumRating;
    }

    public HeistPosition setMinimumSkillLevel(Integer minimumSkillLevel) {
        this.minimumSkillLevel = minimumSkillLevel;
        return this;
    }

    public Integer getMinimumSkillLevel() {
        return minimumSkillLevel;
    }

    public HeistPosition setPositionId(Integer positionId) {
        this.positionId = positionId;
        return this;
    }

    public Integer getPositionId() {
        return positionId;
    }

    @Override
    public String toString() {
        return "HeistPosition{" +
               "criminalId=" + criminalId + '\'' +
               "heistId=" + heistId + '\'' +
               "maximumRating=" + maximumRating + '\'' +
               "maximumSkillLevel=" + maximumSkillLevel + '\'' +
               "minimumRating=" + minimumRating + '\'' +
               "minimumSkillLevel=" + minimumSkillLevel + '\'' +
               "positionId=" + positionId + '\'' +
               '}';
    }
}
