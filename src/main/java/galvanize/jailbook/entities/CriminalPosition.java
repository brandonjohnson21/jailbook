package galvanize.jailbook.entities;

import galvanize.jailbook.entities.idclasses.CriminalPositionIdClass;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Criminal_Position")
@Entity
@IdClass(CriminalPositionIdClass.class)
public class CriminalPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Criminal_ID", nullable = false)
    private Integer criminalId;

    @Id
    @Column(name = "Position_ID", nullable = false)
    private Integer positionId;

    @Column(name = "Skill_Level", nullable = false)
    private Integer skillLevel;

    public CriminalPosition setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
        return this;
    }

    public Integer getCriminalId() {
        return criminalId;
    }

    public CriminalPosition setPositionId(Integer positionId) {
        this.positionId = positionId;
        return this;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public CriminalPosition setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
        return this;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        return "CriminalPosition{" +
               "criminalId=" + criminalId + '\'' +
               "positionId=" + positionId + '\'' +
               "skillLevel=" + skillLevel + '\'' +
               '}';
    }
}
