package vsu.Task3LinAlg;

public class Vector3F implements Vector {

    private final float[] vector = new float[3];

    public Vector3F(float x, float y, float z) {
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
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

    @Override
    public void sum(Vector v) {
        if (v instanceof Vector3F) {
            vector[0] += ((Vector3F) v).getX();
            vector[1] += ((Vector3F) v).getY();
            vector[2] += ((Vector3F) v).getZ();
        } else {
            throw new IllegalArgumentException("В аргументе вектор не той размерности");
        }
    }

    @Override
    public void sub(Vector v) {
        if (v instanceof Vector3F) {
            vector[0] -= ((Vector3F) v).getX();
            vector[1] -= ((Vector3F) v).getY();
            vector[2] -= ((Vector3F) v).getZ();
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
        return (float) Math.sqrt(vector[0] * vector[0] + vector[1] * vector [1] + vector[2] * vector[2]);
    }

    @Override
    public void normalize() {
        float length = getLength();
        if (length > 0.1e-9) {
            vector[0] /= length;
            vector[1] /= length;
            vector[2] /= length;
        }
    }

    @Override
    public float scalMult(Vector v) {
        if (v instanceof Vector3F) {
            return (vector[0] * ((Vector3F) v).getX() + vector[1] * ((Vector3F) v).getY() + vector[2] * ((Vector3F) v).getZ());
        } else {
            throw new IllegalArgumentException("Вектор не той размерности в аргументе");
        }
    }

    public Vector3F vecMult(Vector3F v) {
        float x = vector[1] * v.getZ() - vector[2] * v.getY();
        float y = vector[0] * v.getZ() - vector[2] * v.getX();
        float z = vector[0] * v.getY() - vector[1] * v.getX();
        return new Vector3F(x, y, z);
    }
}
