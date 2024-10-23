package Task2CubicSpline;

import Task1.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Task1.MainWindow window = new MainWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setTitle("CubicSpline");
        window.setVisible(true);
    }
}
