package vsu.Task3LinAlg;

public class Vector2F {
    private final float[] vector = new float[2];

    public Vector2F(float x, float y) {
        vector[0] = x;
        vector[1] = y;
    }

    public void sum(Vector2F v) {
        vector[0] += v.getX();
        vector[1] += v.getY();
    }

    public void sub(Vector2F v) {
        vector[0] -= v.getX();
        vector[1] -= v.getY();
    }

    public void

    public float getX() {
        return vector[0];
    }

    public float getY() {
        return vector[1];
    }
}
