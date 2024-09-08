package Task1;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JFrame {

    private final int BACKGROUND_WIDTH = 300;
    private final int BACKGROUND_HEIGHT = 450;

    public DrawingPanel() {
        setTitle("Drawing Panel");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Bunny bunny = new Bunny(0, 5, 300, 400);
        bunny.draw(g2d);
    }

}
