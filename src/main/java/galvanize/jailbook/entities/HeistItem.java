package galvanize.jailbook.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Heist_Item")
public class HeistItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Bringer", nullable = false)
    private Integer bringer;

    @Column(name = "Heist_ID", nullable = false)
    private Integer heistId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Heist_Item_ID", nullable = false)
    private Integer heistItemId;

    @Column(name = "Item_Description")
    private String itemDescription;

    @Column(name = "Item_Name", nullable = false)
    private String itemName;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    public HeistItem setBringer(Integer bringer) {
        this.bringer = bringer;
        return this;
    }

    public Integer getBringer() {
        return bringer;
    }

    public HeistItem setHeistId(Integer heistId) {
        this.heistId = heistId;
        return this;
    }

    public Integer getHeistId() {
        return heistId;
    }

    public HeistItem setHeistItemId(Integer heistItemId) {
        this.heistItemId = heistItemId;
        return this;
    }

    public Integer getHeistItemId() {
        return heistItemId;
    }

    public HeistItem setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public HeistItem setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public HeistItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "HeistItem{" +
               "bringer=" + bringer + '\'' +
               "heistId=" + heistId + '\'' +
               "heistItemId=" + heistItemId + '\'' +
               "itemDescription=" + itemDescription + '\'' +
               "itemName=" + itemName + '\'' +
               "quantity=" + quantity + '\'' +
               '}';
    }
}
