package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

    private static final int santaImage = 0;
    private static final int presentImage = 1;
    private static final int kidImage = 2;
    private static final int kidAsleepImage = 3;
    private static final int kidFinalImage = 4;

    private int width;
    private int height;
    private static final int size = 52;
    private static final int santaArea = 3;
    private static final int numberOfChildren = 7;

    private List<BufferedImage> images;

    boolean paused = true;

    private Font font = new Font("Arial Black", Font.BOLD, size);

    public Santa santa;
    public List<Child> children;
    public List<Gift> gifts;
    private List<Integer> X;
    private  List<Integer> Y;

    public Canvas(int width, int height, Santa santa) {
        this.width = width;
        this.height = height;
        this.santa = santa;
        this.children = new ArrayList<>();
        this.gifts = new ArrayList<>();

        images = new ArrayList<>();
        try {
            images.add(ImageIO.read(Canvas.class.getResource("../graphics/santa.png")));
            images.add(ImageIO.read(Canvas.class.getResource("../graphics/present.png")));
            images.add(ImageIO.read(Canvas.class.getResource("../graphics/kid.png")));
            images.add(ImageIO.read(Canvas.class.getResource("../graphics/kid-asleep.png")));
            images.add(ImageIO.read(Canvas.class.getResource("../graphics/kid-final.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        X = new ArrayList<>();
        Y = new ArrayList<>();

        for(int i = santaArea; i < width; i++){
            X.add(i);
        }
        for(int i = santaArea; i < height; i++){
            Y.add(i);
        }
        for(int i = 0; i < numberOfChildren; i++){
            int childsX = (int)(Math.random() * (X.size() - santaArea)) + santaArea;
            int childsY = (int)(Math.random() * (Y.size() - santaArea)) + santaArea ;
            X.remove(childsX);
            Y.remove(childsY);
            children.add(new Child(childsX,childsY,this));
        }

        for(Child child : children) {
            child.timer.start();
        }


        setMinimumSize(new Dimension(width*size,height*size));
        setMaximumSize(new Dimension(width*size,height*size));
        setPreferredSize(new Dimension(width*size,height*size));
    }

    public void placeGift(){
        for(Child child : children){
            if(child.isSleeping()){
                if(santa.getY() + 1 == child.getY() && santa.getX() == child.getX() ||
                   santa.getY() - 1 == child.getY() && santa.getX() == child.getX() ||
                   santa.getY() == child.getY() && santa.getX() + 1 == child.getX() ||
                   santa.getY() == child.getY() && santa.getX() - 1 == child.getX()){
                    gifts.add(new Gift(santa.getX(),santa.getY()));
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(font);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width * size, height * size);

        g.setColor(Color.GRAY);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                if (y % 2 != x % 2)
                    g.fillRect(x * size, y * size, size, size);


        for(Gift gift : gifts){
            g.drawImage(images.get(presentImage),gift.getX() * size, gift.getY() * size, size, size, this);
        }

        for (Child child : children) {
            if (child.gifted) {
                g.drawImage(images.get(kidFinalImage),child.getX() * size, child.getY() * size, size, size, this);
            }else if (!child.isSleeping()) {
                g.drawImage(images.get(kidImage),child.getX() * size, child.getY() * size, size, size, this);
            } else {
                g.drawImage(images.get(kidAsleepImage),child.getX() * size, child.getY() * size, size, size, this);
            }


        }

        g.drawImage(images.get(santaImage),santa.getX() * size, santa.getY() * size, size, size, this);

        if(paused) {
            g.setColor(Color.BLACK);
            int w = g.getFontMetrics().stringWidth("GAME PAUSED CLICK ESC");
            int x = (width * size - w)/2;
            g.drawString("GAME PAUSED CLICK ESC", x,(height * size)/2);
        }
    }

}
