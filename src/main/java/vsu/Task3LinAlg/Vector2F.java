package vsu.Task3LinAlg;

public class Vector2F implements Vector {
    private final float[] vector = new float[2];

    public Vector2F(float x, float y) {
        vector[0] = x;
        vector[1] = y;
    }

    public Vector2F(float[] vec) {
        if (vec.length != vector.length) {
            throw new IllegalArgumentException("Это не двумерный вектор");
        } else {
            vector[0] = vec[0];
            vector[1] = vec[1];
        }
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
    public void plus(Vector v) {
        if (v instanceof Vector2F) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += v.get(i);
            }
        } else {
            throw new IllegalArgumentException("В аргументе вектор слишком большой размерности");
        }
    }

    @Override
    public void minus(Vector v) {
        if (v instanceof Vector2F) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= v.get(i);
            }
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
        return (float) Math.sqrt(vector[0] * vector[0] +
                vector[1] * vector[1]);
    }

    @Override
    public void normalize() {
        float length = getLength();
        if (length > 0.1e-9) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] /= length;
            }
        }
    }

    @Override
    public float scalMult(Vector v) {
        if (v instanceof Vector2F) {
            return (vector[0] * v.get(0) +
                    vector[1] * v.get(1));
        } else {
            throw new IllegalArgumentException("Вектор не той размерности в аргументе");
        }
    }

    @Override
    public float get(int index) {
        if (index > vector.length - 1 || index < 0) {
            throw new IllegalArgumentException("Такого индекса нет");
        } else {
            return vector[index];
        }
    }

    @Override
    public void set(int index, float value) {
        if (index > vector.length - 1 || index < 0) {
            throw new IllegalArgumentException("Такого индекса нет");
        } else {
            vector[index] = value;
        }
    }
}
