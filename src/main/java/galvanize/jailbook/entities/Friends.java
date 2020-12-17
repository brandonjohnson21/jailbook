package galvanize.jailbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Friends")
public class Friends implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Friend_One", nullable = false)
    private Integer friendOne;

    @Id
    @Column(name = "Friend_Two", nullable = false)
    private Integer friendTwo;

    public Friends setFriendOne(Integer friendOne) {
        this.friendOne = friendOne;
        return this;
    }

    public Integer getFriendOne() {
        return friendOne;
    }

    public Friends setFriendTwo(Integer friendTwo) {
        this.friendTwo = friendTwo;
        return this;
    }

    public Integer getFriendTwo() {
        return friendTwo;
    }

    @Override
    public String toString() {
        return "Friends{" +
               "friendOne=" + friendOne + '\'' +
               "friendTwo=" + friendTwo + '\'' +
               '}';
    }
}
