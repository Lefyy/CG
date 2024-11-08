package vsu.Task2CubicSpline.Spline;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;


public class WuLine {
    public static void drawLine(int x1, int y1, int x2, int y2, GraphicsContext g) {
        if (x2 < x1) {
            x1 += x2;
            x2 = x1 - x2;
            x1 -= x2;
            y1 += y2;
            y2 = y1 - y2;
            y1 -= y2;
        }
        int dx = x2 - x1;
        int dy = y2 - y1;
        if (dx == 0 || dy == 0) {
            g.setFill(Color.BLACK);
            g.strokeLine(x1, y1, x2, y2);
            return;
        }
        PixelWriter pixel = g.getPixelWriter();
        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            pixel.setColor(x1, y1, Color.BLACK);
            for (int x = x1; x < x2; ++x) {
                pixel.setColor(x, (int) intery, new Color(0, 0, 0, (255 - fractionalPart(intery) * 255) / 255));
                pixel.setColor(x, (int) intery + 1, new Color(0, 0, 0, fractionalPart(intery)));
                intery += gradient;
            }
            pixel.setColor(x2, y2, Color.BLACK);
        } else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            pixel.setColor(x1, y1, Color.BLACK);
            for (int y = y1; y < y2; ++y) {
                pixel.setColor((int) interx, y, new Color(0, 0, 0, (255 - fractionalPart(interx) * 255) / 255));
                pixel.setColor((int) interx + 1, y, new Color(0, 0, 0, fractionalPart(interx)));
                interx += gradient;
            }
            pixel.setColor(x2, y2, Color.BLACK);
        }

    }

    private static float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp;
    }
}
