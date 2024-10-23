package Task2CubicSpline.Spline;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Spline {
    private final LinkedList<Point> VERTEXES = new LinkedList<>();

    public Spline() {

    }

    public Spline(List<Point> vertexes) {
        VERTEXES.addAll(vertexes);
    }

    public void draw(final Graphics gr) {

    }
}
