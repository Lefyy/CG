package vsu.Task3LinAlg;

public class Matrix3F implements Matrix {
    private final float[][] matrix = new float[3][3];

    public Matrix3F(boolean zeroOrOne) {
        if (!zeroOrOne) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][i] = 1;
            }
        }
    }

    public Matrix3F(float[][] m) {
        if (m.length != 3 || m[0].length != 3) {
            throw new IllegalArgumentException("Ты мне дал не 3х3 матрицу");
        }
        for (int i = 0; i < m.length; i++) {
            matrix[i] = m[i].clone();
        }
    }

    @Override
    public void sum(Matrix m) {

    }

    @Override
    public void mult(Vector v) {

    }

    @Override
    public void mult(Matrix m) {

    }

    @Override
    public void transport() {

    }
}
