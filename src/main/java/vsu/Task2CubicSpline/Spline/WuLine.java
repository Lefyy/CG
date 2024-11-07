package vsu.Task2CubicSpline.Spline;

import javafx.scene.canvas.GraphicsContext;
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
            g.strokeLine(x1, y1, x2, y2);
            return;
        }
        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            g.setFill(Color.BLACK);
            g.strokeLine(x1, y1, x1, y1);
            for (int x = x1; x < x2; ++x) {
                g.setFill(new Color(0, 0, 0, (255 - fractionalPart(intery) * 255) / 255));
                g.strokeLine(x, (int) intery, x, (int) intery);
                g.setFill(new Color(0, 0, 0, fractionalPart(intery)));
                g.strokeLine(x, (int) intery + 1, x, (int) intery + 1);
                intery += gradient;
            }
            g.setFill(Color.BLACK);
            g.strokeLine(x2, y2, x2, y2);
        } else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            g.setFill(Color.BLACK);
            g.strokeLine(x1, y1, x1, y1);
            for (int y = y1; y < y2; ++y) {
                g.setFill(new Color(0, 0, 0, (255 - fractionalPart(interx) * 255) / 255));
                g.strokeLine((int) interx, y, (int) interx, y);
                g.setFill(new Color(0, 0, 0, fractionalPart(interx)));
                g.strokeLine((int) interx + 1, y, (int) interx + 1, y);
                interx += gradient;
            }
            g.setFill(Color.BLACK);
            g.strokeLine(x2, y2, x2, y2);
        }

    }

    private static float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp;
    }
}
