package Task1;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JFrame {

    private final int BACKGROUND_WIDTH = 1000;
    private final int BACKGROUND_HEIGHT = 1000;

    public DrawingPanel() {
        setTitle("Drawing Panel");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Bunny bunny = new Bunny(50, 50, 400, 700);
        bunny.draw(g2d);
    }

}
