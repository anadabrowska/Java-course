package controllers;

import game.Game;
import objects.Map;
import objects.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerController extends KeyAdapter {

    private Player player;
    private Map maze;

    public PlayerController(Player player, Map maze){
        this.player = player;
        this.maze = maze;
    }

    public void collision(){
        if((player.dir == 3 && (maze.map[(player.y - player.speed)/ Game.size][player.x/Game.size] == 1 ||
                maze.map[(player.y - player.speed)/ Game.size][(player.x + Game.playerSize)/Game.size] == 1 ||
                player.y - player.speed < 0)) ||
                (player.dir == 0 && (player.y + Game.size + player.speed > Game.h*Game.size ||
                        (maze.map[(player.y + player.speed + Game.playerSize)/ Game.size][player.x/Game.size] == 1 ||
                maze.map[(player.y + player.speed + Game.playerSize)/ Game.size][(player.x + Game.playerSize)/Game.size] == 1))) ||
                (player.dir == 2 && (player.x + Game.size + player.speed > Game.w*Game.size ||
                        (maze.map[player.y/ Game.size][(player.x + player.speed + Game.playerSize)/Game.size] == 1 ||
                maze.map[(player.y + Game.playerSize)/ Game.size][(player.x + player.speed + Game.playerSize)/Game.size] == 1))) ||
                (player.dir == 1 && (maze.map[player.y / Game.size][(player.x - player.speed)/Game.size] == 1 ||
                maze.map[(player.y + Game.playerSize)/ Game.size][(player.x - player.speed)/Game.size] == 1 ||
                player.x - player.speed < 0 ))){
            player.dir = -1;
        }
    }

    public void success(){
        if((player.y + Game.playerSize)/Game.size == maze.start.getY() && (player.x + player.speed)/Game.size == maze.start.getX()){
            Game.running = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch (key){
            case 38:    //UP
                player.dir = 3;
                break;
            case 40:    //DOWN
                player.dir = 0;
                break;
            case 39:    //RIGHT
                player.dir = 2;
                break;
            case 37:    //LEFT
                player.dir = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        player.dir = -1;
    }
}
