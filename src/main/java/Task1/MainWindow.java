package Task1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawingPanel panel;

    public MainWindow() throws HeadlessException {
        panel = new DrawingPanel(this.getWidth(), this.getHeight(), 100);
        this.add(panel);
    }

}
