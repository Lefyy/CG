package vsu.Task2CubicSpline;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import vsu.Task2CubicSpline.Spline.Spline2D;

import java.util.ArrayList;

public class CurveDrawingController {
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    private ArrayList<Integer> Xs = new ArrayList<>();
    private ArrayList<Integer> Ys = new ArrayList<>();

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY -> handlePrimaryClick(canvas.getGraphicsContext2D(), event);
            }
        });
    }

    private void handlePrimaryClick(GraphicsContext graphicsContext, MouseEvent event) {
        final Point2D clickPoint = new Point2D(event.getX(), event.getY());

        Xs.add((int) event.getX());
        Ys.add((int) event.getY());

        final int POINT_RADIUS = 3;
        graphicsContext.fillOval(
                clickPoint.getX() - POINT_RADIUS, clickPoint.getY() - POINT_RADIUS,
                2 * POINT_RADIUS, 2 * POINT_RADIUS);


        if (Xs.size() > 2) {
            PixelWriter writer = graphicsContext.getPixelWriter();
            Spline2D spline2D = new Spline2D(Xs, Ys);
            for (int i = 1; i < Xs.size(); i++) {
                for (int j = Xs.get(i - 1); j < Xs.get(i); j++) {
                    int[] cords = spline2D.getPoint(j);
                    writer.setColor(cords[0], cords[1], Color.BLACK);
                }
            }
        } else if (Xs.size() == 2) {
            graphicsContext.strokeLine(Xs.get(0), Ys.get(0), Xs.get(1), Ys.get(1));
        }

    }
}
