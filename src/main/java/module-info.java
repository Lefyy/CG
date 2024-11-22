module Task2CubicSpline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.incubator.vector;

    opens vsu.Task2CubicSpline to javafx.fxml;
    exports vsu.Task2CubicSpline;
}