package vsu.Task3LinAlg;

public class Matrix3F implements Matrix {
    private final float[][] matrix = new float[3][3];

    public Matrix3F() {

    }
    public Matrix3F(boolean isIdentityMatrix) {
        if (isIdentityMatrix) {
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
        if (m instanceof Matrix3F) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] += m.get(i, j);
                }
            }
        } else {
            throw new IllegalArgumentException("Я не могу складывать матрицы разной размерности");
        }
    }

    @Override
    public Vector mult(Vector v) {
        if (v instanceof Vector3F) {
            float[] vec = new float[3];
            for (int i = 0; i < 3; i++) {
                vec[i] += matrix[i][0] * ((Vector3F) v).getX();
                vec[i] += matrix[i][1] * ((Vector3F) v).getY();
                vec[i] += matrix[i][2] * ((Vector3F) v).getZ();
            }
            return new Vector3F(vec);
        } else {
            throw new IllegalArgumentException("Я не могу умножить трехмерную матрицу на нетрехмерный вектор");
        }
    }

    @Override
    public void mult(Matrix m) {
        if (m instanceof Matrix3F) {
            for
        }
    }

    @Override
    public void transpose() {

    }

    @Override
    public float get(int row, int col) {
        if (row > 3 || col > 3 || row < 0 || col < 0) {
            throw new IllegalArgumentException("Что что ты хочешь взять из матрицы 3на3");
        } else {
            return matrix[row][col];
        }
    }
}
