package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Layout implements ActionListener {

    private Window window;
    private JFileChooser fileChooser;

    private Canvas canvas;
    private JScrollPane scroll;
    private JMenuItem loadImageBtn;
    private JMenuItem saveImageBtn;
    private Toolbar toolbar;

     Layout(Window window){
        createFileChooser();

        this.window = window;
        createWindow();

        createMenu();
        createCanvas();

        toolbar = new Toolbar(this);
        window.add(toolbar, BorderLayout.NORTH);
        window.add(canvas.label,BorderLayout.SOUTH);
    }

    private void createFileChooser() {
        FileFilter filterJPEG = new FileNameExtensionFilter("JPEG images", "jpg", "jpeg");
        FileFilter filterPNG  = new FileNameExtensionFilter("PNG images", "png");
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select image to import");
        fileChooser.addChoosableFileFilter(filterJPEG);
        fileChooser.addChoosableFileFilter(filterPNG);
        fileChooser.setAcceptAllFileFilterUsed(false);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.window.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        loadImageBtn = new JMenuItem("Load image");
        loadImageBtn.addActionListener(this);
        fileMenu.add(loadImageBtn);

        saveImageBtn = new JMenuItem("Save file");
        saveImageBtn.addActionListener(this);
        fileMenu.add(saveImageBtn);
    }

    private void createWindow() {
        window.setSize(Window.width, Window.height);
        window.setTitle("Paint");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setResizable(false);
        window.setVisible(true);
    }

    public void createCanvas() {
        canvas = new Canvas(1, 1);
        scroll = new JScrollPane(canvas);
        window.add(scroll, BorderLayout.CENTER);
        window.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loadImageBtn) {
            int result = fileChooser.showOpenDialog(window);
            if(result == JFileChooser.APPROVE_OPTION) {
                canvas.setImage(fileChooser.getSelectedFile());
                window.revalidate();
            }
        }else if(e.getSource() == saveImageBtn){
            int result = fileChooser.showSaveDialog(window);
            if(result == JFileChooser.APPROVE_OPTION) {
                try {
                    ImageIO.write(canvas.image, "png" ,fileChooser.getSelectedFile());
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
        }else if(e.getSource() == toolbar.lColorBtn) {
            Color nextColor = JColorChooser.showDialog(null, "First Color", canvas.leftColor);
            if (nextColor != null) {
                canvas.leftColor = nextColor;
            }
        }else if(e.getSource() == toolbar.rColorBtn){
            Color nextColor = JColorChooser.showDialog(null, "Second Color", canvas.rightColor);
            if (nextColor != null) {
                canvas.rightColor = nextColor;
            }
        }else if(e.getSource() == toolbar.zoomInBtn){
            canvas.zoomIn();
        }else if(e.getSource() == toolbar.zoomOutBtn){
            canvas.zoomOut();
        }else if(e.getSource() == toolbar.moveLeftBtn){
            scroll.getHorizontalScrollBar().setValue(0);
        }else if(e.getSource() == toolbar.moveRightBtn){
            scroll.getHorizontalScrollBar().setValue(canvas.image.getHeight());
        }else if(e.getSource() == toolbar.moveUpBtn){
            scroll.getVerticalScrollBar().setValue(0);
        }else if(e.getSource() == toolbar.moveDownBtn){
            scroll.getVerticalScrollBar().setValue(canvas.image.getWidth());
        }
    }
}
