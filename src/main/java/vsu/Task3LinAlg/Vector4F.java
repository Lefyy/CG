package vsu.Task3LinAlg;

public class Vector4F implements Vector {
    private final float[] vector = new float[4];

    public Vector4F(float x, float y, float z, float w) {
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
        vector[3] = w;
    }

    public float getX() {
        return vector[0];
    }

    public float getY() {
        return vector[1];
    }

    public float getZ() {
        return vector[2];
    }

    public float getW() {
        return vector[3];
    }

    @Override
    public void sum(Vector v) {
        if (v instanceof Vector4F) {
            vector[0] += ((Vector4F) v).getX();
            vector[1] += ((Vector4F) v).getY();
            vector[2] += ((Vector4F) v).getZ();
            vector[3] += ((Vector4F) v).getW();
        } else {
            throw new IllegalArgumentException("В аргументе вектор не той размерности");
        }
    }

    @Override
    public void sub(Vector v) {
        if (v instanceof Vector4F) {
            vector[0] -= ((Vector4F) v).getX();
            vector[1] -= ((Vector4F) v).getY();
            vector[2] -= ((Vector4F) v).getZ();
            vector[3] -= ((Vector4F) v).getW();
        } else {
            throw new IllegalArgumentException("В аргументе вектор не той размерности");
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
        return (float) Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1] + vector[2] * vector[2] + vector[3] * vector[3]);
    }

    @Override
    public void normalize() {
        float length = getLength();
        if (length > 0.1e-9) {
            vector[0] /= length;
            vector[1] /= length;
            vector[2] /= length;
            vector[3] /= length;
        }
    }

    @Override
    public float scalMult(Vector v) {
        if (v instanceof Vector4F) {
            return (vector[0] * ((Vector4F) v).getX() +
                    vector[1] * ((Vector4F) v).getY() +
                    vector[2] * ((Vector4F) v).getZ() +
                    vector[3] * ((Vector4F) v).getW());
        } else {
            throw new IllegalArgumentException("Вектор не той размерности в аргументе");
        }
    }
}
