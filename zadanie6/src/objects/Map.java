package objects;

import game.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class Map {

    public BufferedImage floor;
    public  BufferedImage door;

    {
        try {
            floor = ImageIO.read(Player.class.getResource("/graphics/stone2.png"));
            door = ImageIO.read(Player.class.getResource("/graphics/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] map;
    public Point first = null;
    public Point start = null;


    public Map(){
        map = new int[Game.h][Game.w];
        primsAlg();
    }


    private void primsAlg(){
        // build maze and initialize with only walls
        for (int y = 0; y < Game.h; y++){
            for(int x = 0; x < Game.w ; x++){
                map[y][x] = 1;
            }
        }

        //starting point
        start = new Point(Game.w-1, 0, null);
        map[start.r][start.c] = 2; //last

        // iterate through direct neighbors of node
        ArrayList < Point > frontier = new ArrayList < Point > ();
        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x != 0 && y != 0)
                    continue;
                try {
                    if (map[start.r + x][start.c + y] == 0) continue;
                } catch (Exception e) {
                    continue;
                }
                // add points to frontier
                frontier.add(new Point(start.r + x, start.c + y, start));
            }

        while (!frontier.isEmpty()) {

            // pick current node at random
            Point cu = frontier.remove((int)(Math.random() * frontier.size()));
            Point op = cu.opposite();
                // if both node and its opposite are walls
                if (map[cu.r][cu.c] == 1) {
                    if (map[op.r][op.c] == 1) {

                        // open path between the nodes
                        map[cu.r][cu.c] = 0;
                        map[op.r][op.c] = 0;

                        // store first node in order to mark it later
                        first = op;

                        // iterate through direct neighbors of node, same as earlier
                        for (int x = -1; x <= 1; x++)
                            for (int y = -1; y <= 1; y++) {
                                if (x == 0 && y == 0 || x != 0 && y != 0)
                                    continue;
                                try {
                                    if (map[op.r + x][op.c + y] == 0) continue;
                                } catch (Exception e) {
                                    continue;
                                }
                                frontier.add(new Point(op.r + x, op.c + y, op));
                            }
                    }
                }

            // if algorithm has resolved, mark end node
            if (frontier.isEmpty())
                map[first.r][first.c] = 2;
        }

    }

    public class Point {
        Integer r;
        Integer c;
        Point parent;
        public Point(int x, int y, Point p) {
            r = x;
            c = y;
            parent = p;
        }
        // compute opposite node given that it is in the other direction from the parent
        public Point opposite() {
            if (this.r.compareTo(parent.r) != 0)
                return new Point(this.r + this.r.compareTo(parent.r), this.c, this);
            if (this.c.compareTo(parent.c) != 0)
                return new Point(this.r, this.c + this.c.compareTo(parent.c), this);
            return null;
        }

        public int getX(){
            return r;
        }
        public int getY(){
            return c;
        }
    }

}

