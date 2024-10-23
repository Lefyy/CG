package Task2CubicSpline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingPanel extends JPanel implements MouseListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;

    public DrawingPanel(final int width, final int height) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
