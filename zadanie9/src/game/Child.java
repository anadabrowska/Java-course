package game;

import window.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Child implements ActionListener, Serializable {

    private static final int range = 5;
    private static final int speed = 1;

    private int x;
    private int y;

    private int steps;
    private int maxSteps;
    private int timeAsleep;
    private int maxSleep;
    public boolean gifted = false;


    public Timer timer;
    public Canvas canvas;

    Child(int x, int y, Canvas canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;

        steps = 0;
        maxSteps = (int)(Math.random() * 4) + 1;
        timeAsleep = 0;
        maxSleep = (int)(Math.random() * 4) + 1;

        timer = new Timer(1000/speed, this);
    }

    private boolean isSantaVisible(){
        return canvas.santa.getX() <= x + range && canvas.santa.getX() >= x - range &&
               canvas.santa.getY() <= y + range && canvas.santa.getY() >= y - range;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSleeping() {
        return steps >= maxSteps;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized (canvas) {
            if(canvas.paused) return;

            if (isSleeping()) {
                timeAsleep++;

                if (timeAsleep >= maxSleep) {
                    steps = 0;
                    timeAsleep = 0;
                    maxSteps = (int) (Math.random() * 4) + 3;
                    maxSleep = (int) (Math.random() * 3) + 2;

                    for(int i = 0; i < canvas.gifts.size(); i++) {
                        Gift gift = canvas.gifts.get(i);
                        if(gift.getY() + 1 == y && gift.getX() == x ||
                           gift.getY() - 1 == y && gift.getX() == x ||
                           gift.getY() == y && gift.getX() + 1 == x ||
                           gift.getY() == y && gift.getX() - 1 == x){

                            x = gift.getX();
                            y = gift.getY();

                            canvas.gifts.remove(i);
                            gifted = true;
                            timer.stop();
                        }
                    }
                }

                return;
            }

            steps++;
            if (isSantaVisible()) {
                if (Math.abs(canvas.santa.getX() - x) > Math.abs(canvas.santa.getY() - y)) {
                    if (canvas.santa.getX() > x) {
                        moveRight();
                    } else {
                        moveLeft();
                    }
                } else {
                    if (canvas.santa.getY() > y) {
                        moveDown();
                    } else {
                        moveUp();
                    }
                }
            } else {
                int direction = (int) (Math.random() * 4);
                switch (direction) {
                    case 0: //UP
                        moveUp();
                        break;
                    case 1: //DOWN
                        moveDown();
                        break;
                    case 2: //LEFT
                        moveLeft();
                        break;
                    case 3: //RIGHT
                        moveRight();
                }
            }
        }
    }

    private void moveUp(){
        if(y - 1 < 0){
            y = Window.height - 1;
        }else{
            y--;
        }
    }

    private void moveDown(){
        if(y + 1 >= Window.height){
            y = 0;
        }else {
            y++;
        }
    }

    private void moveRight(){
        if(x + 1 >= Window.width){
            x = 0;
        }else {
            x++;
        }
    }

    private void moveLeft(){
        if(x - 1 < 0){
            x = Window.width-1;
        }else {
            x--;
        }
    }
}
