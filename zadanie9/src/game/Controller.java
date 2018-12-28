package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter{

    private Canvas canvas;

    public Controller(Canvas canvas){
        this.canvas = canvas;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case 38: //UP
                if(!canvas.paused)
                    canvas.santa.moveUp();
                break;
            case 40: //DOWN
                if(!canvas.paused)
                    canvas.santa.moveDown();
                break;
            case 39: //RIGHT
                if(!canvas.paused)
                    canvas.santa.moveRight();
                break;
            case 37: //LEFT
                if(!canvas.paused)
                    canvas.santa.moveLeft();
                break;
            case 32: //SPACE
                canvas.placeGift();
                break;
            case 27: //ESC
                canvas.paused = !canvas.paused;
        }
    }
}
