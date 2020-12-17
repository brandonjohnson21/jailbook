package galvanize.jailbook.entities.idclasses;

import java.io.Serializable;

public class CriminalPositionIdClass implements Serializable {
    private Integer criminalId;
    private Integer positionId;

    public Integer getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
