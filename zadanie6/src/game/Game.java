package game;

import controllers.PlayerController;
import objects.Map;
import objects.Player;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas{

    public static final int w = 19;
    public static final int h = 19;
    public static final int size = 40;
    public static final int playerSize = (int)Math.floor(size * 0.75);

    private JFrame frame;

    private Map maze;
    private Player player;
    private PlayerController controller;

    public static boolean running;

    public Game(){
        maze = new Map();
        player = new Player(maze.first.getX() * size,maze.first.getY()*size);
        controller = new PlayerController(player, maze);

        setMaximumSize(new Dimension(w * size,h * size));
        setMinimumSize(new Dimension(w * size,h * size));
        setPreferredSize(new Dimension(w * size,h * size));

        frame = new JFrame("Maze game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        this.setFocusable(true);
        this.addKeyListener(controller);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0,0,w*size,h*size);

        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                if(maze.map[y][x] == 1){
                    g.drawImage(maze.floor,x*size,y*size,size,size,this);
                }
                else if(maze.map[x][y] == 2){
                    g.drawImage(maze.door,x*size,y*size,size,size,this);
                }

            }
        }

        g.drawImage(player.img[player.animationDir*3 + player.animation], player.x, player.y, playerSize, playerSize,this);
    }

    private synchronized void start(){
        running = true;
        run();
    }

    public void run(){
        int frames = 0;
        int framesForAnimation = 30; // fps/animationCount
        while(running){
            controller.collision();
            controller.success();
            player.go();
            repaint();
            try {
                this.wait(1000/120); //120fps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(frames > framesForAnimation){
                player.animate();
                frames = 0;
            }else{
                frames++;
            }
        }
        System.exit(0);
    }

    public static void main(String[] args){
        new Game().start();
    }

}
