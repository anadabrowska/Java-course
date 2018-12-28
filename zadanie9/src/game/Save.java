package game;

import java.io.Serializable;
import java.util.List;

public class Save implements Serializable {

    public List<Gift> gifts;
    public List<Child> children;
    public Santa santa;

    public Save(List<Gift> gifts, List<Child> children, Santa santa) {
        this.gifts = gifts;
        this.children = children;
        this.santa = santa;
    }

}
