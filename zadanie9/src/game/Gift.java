package game;

import java.io.Serializable;

class Gift implements Serializable {

    private int x;
    private int y;

    Gift(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
