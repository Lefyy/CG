package Task2CubicSpline.Spline;

import java.util.Objects;

public class Point {
    private final float X;
    private final float Y;
    public Point(float x, float y) {
        this.X = x;
        this.Y = y;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Float.compare(X, point.X) == 0 && Float.compare(Y, point.Y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
