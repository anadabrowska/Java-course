package window;

import game.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Window implements ActionListener {

    private static final int FPS = 1000/60;
    public static final int width = 20;
    public static final int height = 15;

    private JFrame frame;
    private Santa santa;
    private Canvas canvas;


    private Window(){
        santa = new Santa(0,0);

        frame = new JFrame("Chasing after Santa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        addMenu();

        canvas = new Canvas(width, height, santa);
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack(); //window gets canvas size

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Controller controller = new Controller(canvas);

        canvas.setFocusable(true);
        canvas.addKeyListener(controller);

        new Timer(FPS,this).start();

    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");

        save.addActionListener((ActionEvent e) -> {
            Save save1 = new Save(canvas.gifts, canvas.children, santa);

            for(Child child : canvas.children){
                child.timer.stop();
                child.canvas = null;
            }

            try {
                File file = new File("game.save");
                file.createNewFile();
                FileOutputStream fileOut =
                        new FileOutputStream(file, false);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(save1);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }

            for(Child child : canvas.children) {
                child.canvas = canvas;
                if(!child.gifted)
                    child.timer.start();
            }
        });

        load.addActionListener((ActionEvent e) -> {
            Save save1 = null;

            try {
                FileInputStream fileIn = new FileInputStream("game.save");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                save1 = (Save) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }

            if(save1 != null) {
                for(Child child : canvas.children){
                    child.timer.stop();
                    child.canvas = null;
                }

                canvas.gifts = save1.gifts;
                canvas.children = save1.children;
                santa = save1.santa;
                canvas.santa = santa;

                for(Child child : canvas.children){
                    child.canvas = canvas;
                    if(!child.gifted)
                        child.timer.start();
                }
            }
        });

        gameMenu.add(save);
        gameMenu.add(load);

        frame.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized (canvas) {
            canvas.repaint();
            boolean end = true;
            for(Child child : canvas.children){
                if(!child.gifted){
                    end = false;
                }
                if(!child.isSleeping() && !child.gifted){
                    if(santa.getY() + 1 == child.getY() && santa.getX() == child.getX() ||
                       santa.getY() - 1 == child.getY() && santa.getX() == child.getX() ||
                       santa.getY() == child.getY() && santa.getX() + 1 == child.getX() ||
                       santa.getY() == child.getY() && santa.getX() - 1 == child.getX()){

                        end = true;
                        break;
                    }
                }
            }
            if(end){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args){
        new Window();
    }

}
