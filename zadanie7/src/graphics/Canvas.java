package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {


     BufferedImage image;

     Draw draw;

     double scale = 1;
     double maxScale = 8;
     double minScale = 1;

     Color leftColor = Color.RED;
     Color rightColor = Color.BLACK;

     JLabel label;

     Canvas(int width, int height){
        draw = new Draw(this);
        label = new JLabel("Mouse x: "+ draw.x+", Mouse y: "+draw.y);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);

        this.setBounds(0,0,width,height);
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseMotionListener(draw);
    }

    public void setImage(File file){
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(0, 0, image.getWidth(), image.getHeight());
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }


    public void zoomIn() {
        if(scale < maxScale) {
            scale++;
            this.setBounds(0, 0, (int)(image.getWidth() * scale), (int)(image.getHeight() * scale));
            this.setPreferredSize(new Dimension((int)(image.getWidth() * scale), (int)(image.getHeight() * scale)));
            repaint();
        }

    }

    public void zoomOut() {
        if(scale > minScale) {
            scale--;
            this.setBounds(0, 0, (int)(image.getWidth() * scale), (int)(image.getHeight() * scale));
            this.setPreferredSize(new Dimension((int)(image.getWidth() * scale), (int)(image.getHeight() * scale)));
            repaint();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ((Graphics2D) g).scale(scale, scale);

        g.drawImage(image, 0,0, this);
    }
}
