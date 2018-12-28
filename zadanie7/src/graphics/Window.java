package graphics;

import javax.swing.*;

public class Window extends JFrame {

     static final int width = 1024;
     static final int height = 768;

    private Layout layout;

    private Window(){
       layout = new Layout(this);
    }

    public static void main(String[] args){
        new Window();
    }
}
