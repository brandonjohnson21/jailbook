package galvanize.jailbook.entities.idclasses;

import java.io.Serializable;

public class FriendsIdClass implements Serializable {
    private Integer friendOne;
    private Integer friendTwo;

    public Integer getFriendOne() {
        return friendOne;
    }

    public void setFriendOne(Integer friendOne) {
        this.friendOne = friendOne;
    }

    public Integer getFriendTwo() {
        return friendTwo;
    }

    public void setFriendTwo(Integer friendTwo) {
        this.friendTwo = friendTwo;
    }
}
