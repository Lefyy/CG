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
        if (m.length != matrix.length || m[0].length != matrix[0].length) {
            throw new IllegalArgumentException("Ты мне дал не 3х3 матрицу");
        } else {
            for (int i = 0; i < m.length; i++) {
                matrix[i] = m[i].clone();
            }
        }
    }

    private void reInitMatrix(float[][] m) {
        if (m.length != matrix.length || m[0].length != matrix[0].length) {
            throw new IllegalArgumentException("Ты мне дал не 3х3 матрицу");
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = m[i].clone();
        }
    }

    @Override
    public void sum(Matrix m) {
        if (m instanceof Matrix3F) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] += m.get(i, j);
                }
            }
        } else {
            throw new IllegalArgumentException("Я не могу складывать матрицы разной размерности");
        }
    }

    @Override
    public Vector3F mult(Vector v) {
        if (v instanceof Vector3F) {
            float[] vec = new float[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    vec[i] += matrix[i][j] * v.get(j);
                }
            }
            return new Vector3F(vec);
        } else {
            throw new IllegalArgumentException("Я не могу умножить трехмерную матрицу на нетрехмерный вектор");
        }
    }

    @Override
    public void mult(Matrix m) {
        if (m instanceof Matrix3F) {
            float[][] newMatrix = new float[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    newMatrix[i][j] = matrix[i][0] * m.get(0, j) +
                            matrix[i][1] * m.get(1, j) +
                            matrix[i][2] * m.get(2, j);
                }
            }
            reInitMatrix(newMatrix);
        } else {
            throw new IllegalArgumentException("Матрицы разных размерностей не умею перемножать");
        }
    }

    @Override
    public void transpose() {
        float[] temp;
        for (int i = 0; i < matrix.length; i++) {
            temp = matrix[i].clone();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp[j];
            }
        }
    }

    @Override
    public float get(int row, int col) {
        if (row > matrix.length - 1 || col > matrix[0].length - 1 || row < 0 || col < 0) {
            throw new IllegalArgumentException("Что что ты хочешь взять из матрицы 3на3");
        } else {
            return matrix[row][col];
        }
    }

    @Override
    public void set(int row, int col, float value) {
        if (row > matrix.length - 1 || col > matrix[0].length - 1 || row < 0 || col < 0) {
            throw new IllegalArgumentException("Что что ты хочешь взять из матрицы 3на3");
        } else {
            matrix[row][col] = value;
        }
    }
}
