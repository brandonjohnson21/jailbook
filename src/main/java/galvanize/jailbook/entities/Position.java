package galvanize.jailbook.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Position_Description")
    private String positionDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Position_ID", nullable = false)
    private Integer positionId;

    @Column(name = "Position_Name", nullable = false)
    private String positionName;

    public Position setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
        return this;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public Position setPositionId(Integer positionId) {
        this.positionId = positionId;
        return this;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public Position setPositionName(String positionName) {
        this.positionName = positionName;
        return this;
    }

    public String getPositionName() {
        return positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
               "positionDescription=" + positionDescription + '\'' +
               "positionId=" + positionId + '\'' +
               "positionName=" + positionName + '\'' +
               '}';
    }
}
