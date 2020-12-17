package galvanize.jailbook.entities.idclasses;

import java.io.Serializable;

public class HeistPositionIdClass implements Serializable {
    private Integer criminalId;
    private Integer heistId;

    public Integer getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
    }

    public Integer getHeistId() {
        return heistId;
    }

    public void setHeistId(Integer heistId) {
        this.heistId = heistId;
    }

}
