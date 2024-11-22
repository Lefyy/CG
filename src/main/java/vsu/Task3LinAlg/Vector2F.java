package vsu.Task3LinAlg;

public class Vector2F implements Vector {
    private final float[] vector = new float[2];

    public Vector2F(float x, float y) {
        vector[0] = x;
        vector[1] = y;
    }

    public float getX() {
        return vector[0];
    }

    public float getY() {
        return vector[1];
    }

    public Vector3F toVector3F() {
        return new Vector3F(vector[0], vector[1], 0);
    }

    @Override
    public void sum(Vector v) {
        if (v instanceof Vector2F) {
            vector[0] += ((Vector2F) v).getX();
            vector[1] += ((Vector2F) v).getY();
        } else {
            throw new IllegalArgumentException("В аргументе вектор слишком большой размерности");
        }
    }

    @Override
    public void sub(Vector v) {
        if (v instanceof Vector2F) {
            vector[0] -= ((Vector2F) v).getX();
            vector[1] -= ((Vector2F) v).getY();
        } else {
            throw new IllegalArgumentException("В аргументе вектор слишком большой размерности");
        }
    }

    @Override
    public void mult(float a) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= a;
        }
    }

    @Override
    public void div(float a) {
        if (a < 0.1e-9) {
            throw new IllegalArgumentException("Ты зачем хочешь, чтобы я делил на 0");
        } else {
            mult(1 / a);
        }
    }

    @Override
    public float getLength() {
        return (float) Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);
    }

    @Override
    public void normalize() {
        float length = getLength();
        if (length > 0.1e-9) {
            vector[0] /= length;
            vector[1] /= length;
        }
    }

    @Override
    public float scalMult(Vector v) {
        if (v instanceof Vector2F) {
            return (vector[0] * ((Vector2F) v).getX() + vector[1] * ((Vector2F) v).getY());
        } else {
            throw new IllegalArgumentException("Вектор не той размерности в аргументе");
        }
    }
}
