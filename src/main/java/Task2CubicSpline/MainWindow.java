package Task2CubicSpline;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    DrawingPanel panel;

    public MainWindow() throws HeadlessException {
        panel = new DrawingPanel(this.getWidth(), this.getHeight());
        this.add(panel);
    }
}
