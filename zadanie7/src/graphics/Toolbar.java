package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Toolbar extends JToolBar {

    private Layout layout;

    public JButton lColorBtn;
    public JButton rColorBtn;
    public JButton zoomInBtn;
    public JButton zoomOutBtn;
    public JButton moveUpBtn;
    public JButton moveDownBtn;
    public JButton moveLeftBtn;
    public JButton moveRightBtn;


    public Toolbar(Layout layout){
        this.layout = layout;
        setButtons();
    }

    private void setButtons(){

        Image img;

        lColorBtn = new JButton("LeftColor");
        lColorBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../paintbucketleft.png"));
            lColorBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(lColorBtn);

        rColorBtn = new JButton("RightColor");
        rColorBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../paintbucket.png"));
            rColorBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(rColorBtn);

        zoomInBtn = new JButton("ZoomIn");
        zoomInBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../zoomin.jpg"));
            zoomInBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(zoomInBtn);

        zoomOutBtn = new JButton("ZoomOut");
        zoomOutBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../zoomout.png"));
            zoomOutBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(zoomOutBtn);

        moveUpBtn = new JButton("MoveUp");
        moveUpBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../up.jpg"));
            moveUpBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(moveUpBtn);

        moveDownBtn = new JButton("MoveDown");
        moveDownBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../down.png"));
            moveDownBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(moveDownBtn);

        moveLeftBtn = new JButton("MoveLeft");
        moveLeftBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../left.png"));
            moveLeftBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(moveLeftBtn);

        moveRightBtn = new JButton("MoveRight");
        moveRightBtn.addActionListener(layout);
        try {
            img = ImageIO.read(getClass().getResource("../right.jpg"));
            moveRightBtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(moveRightBtn);
    }
}
