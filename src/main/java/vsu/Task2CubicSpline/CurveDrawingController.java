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
import vsu.Task2CubicSpline.Spline.WuLine;

import java.awt.*;
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
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (!Xs.isEmpty() && (Xs.getLast() != (int) event.getX()) && (Ys.getLast() != (int) event.getY())) {
            Xs.add((int) event.getX());
            Ys.add((int) event.getY());
        } else if (Xs.isEmpty()) {
            Xs.add((int) event.getX());
            Ys.add((int) event.getY());
        }

        final int POINT_RADIUS = 3;
        for (int i = 0; i < Xs.size(); i++) {
            graphicsContext.fillOval(
                    Xs.get(i) - POINT_RADIUS, Ys.get(i) - POINT_RADIUS,
                    2 * POINT_RADIUS, 2 * POINT_RADIUS);
        }


        if (Xs.size() > 1) {
            PixelWriter writer = graphicsContext.getPixelWriter();
            Spline2D spline2D = new Spline2D(Xs, Ys);

            int[] startCords = spline2D.getPoint(0);
            for (int i = 1; i < spline2D.getLastParam(); i++) {
                int[] cords = spline2D.getPoint(i);
                WuLine.drawLine(startCords[0], startCords[1], cords[0], cords[1], graphicsContext);
                startCords = cords.clone();
//                writer.setColor(cords[0], cords[1], Color.BLACK);
            }

        }

    }
}
