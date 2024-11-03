module Task2CubicSpline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens vsu.Task2CubicSpline to javafx.fxml;
    exports vsu.Task2CubicSpline;
}