package graphics;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Draw implements MouseMotionListener {

    public int x = 0 , y = 0;
    private Canvas canvas;

    public Draw(Canvas canvas){
        this.canvas = canvas;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        Graphics2D g = (Graphics2D) canvas.image.getGraphics();

        int left = MouseEvent.BUTTON1_DOWN_MASK;
        int right = MouseEvent.BUTTON2_DOWN_MASK;
        if ((e.getModifiersEx() & (left | right)) == left) {
            g.setColor(canvas.leftColor);
        }else {
            g.setColor(canvas.rightColor);
        }

        g.fillOval((int) (x/canvas.scale), (int) (y/canvas.scale),10,10);
        canvas.repaint();
        canvas.label.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        canvas.label.setText("Mouse x: "+ (int)(x/canvas.scale) +", Mouse y: "+ (int)(y/canvas.scale));
    }
}
