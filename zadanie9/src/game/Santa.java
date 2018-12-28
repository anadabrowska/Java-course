package game;

import window.Window;

import java.io.Serializable;

public class Santa implements Serializable {

    private int x;
    private int y;

    public Santa(int x,int y){
        this.x = x;
        this.y = y;
    }

    void moveUp(){
        if(y - 1 < 0){
            y = Window.height - 1;
        }else{
            y--;
        }
    }

    void moveDown(){
        if(y + 1 >= Window.height){
            y = 0;
        }else {
            y++;
        }
    }

    void moveRight(){
        if(x + 1 >= Window.width){
            x = 0;
        }else {
            x++;
        }
    }

    void moveLeft(){
        if(x - 1 < 0){
            x = Window.width-1;
        }else {
            x--;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
