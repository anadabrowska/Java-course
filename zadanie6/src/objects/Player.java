package objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {

    public BufferedImage[] img;

    public int animationCount = 3;

    public int x;
    public int y;
    public int dir = -1;
    public int animation = 0;
    public int animationDir = 0;
    public final int speed = 1;

    public Player(int x, int y){
        this.x = x;
        this.y = y;

        img = null;
        try {
            BufferedImage sprite = ImageIO.read(Player.class.getResource("/graphics/princess.png"));

            int rows = 4;
            int cols = 3;
            int size = 32;

            img = new BufferedImage[rows * cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    img[(i * cols) + j] = sprite.getSubimage(
                        j * size,
                        i * size,
                        size,
                        size
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void animate() {
        if(dir != -1) {
            animation++;
            animation %= animationCount;
        }
    }

    public void go() {
        if(dir != -1) animationDir = dir;

        switch(dir){
            case 0:
                y += speed;
                break;
            case 1:
                x -= speed;
                break;
            case 2:
                x += speed;
                break;
            case 3:
                y -= speed;
        }
    }

}
