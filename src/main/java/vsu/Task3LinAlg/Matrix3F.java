package vsu.Task3LinAlg;

import java.util.Objects;

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
    public Matrix3F mult(Matrix m) {
        if (m instanceof Matrix3F) {
            float[][] newMatrix = new float[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    newMatrix[i][j] = matrix[i][0] * m.get(0, j) +
                            matrix[i][1] * m.get(1, j) +
                            matrix[i][2] * m.get(2, j);
                }
            }
            return new Matrix3F(newMatrix);
        } else {
            throw new IllegalArgumentException("Матрицы разных размерностей не умею перемножать");
        }
    }

    @Override
    public Matrix3F mult(float a) {
        float[][] m = cloneMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                m[i][j] *= a;
            }
        }
        return new Matrix3F(m);
    }

    @Override
    public void transpose() {
        float[][] transposed = new float[matrix.length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        reInitMatrix(transposed);
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
    public Vector3F getRow(int index) {
        if (index < 0 || index > matrix.length) {
            throw new IllegalArgumentException("Такого индекса нету у меня");
        } else {
            return new Vector3F(matrix[index][0], matrix[index][1], matrix[index][2]);
        }
    }

    @Override
    public Vector3F getCol(int index) {
        if (index < 0 || index > matrix[0].length) {
            throw new IllegalArgumentException("Такого индекса нету у меня");
        } else {
            return new Vector3F(matrix[0][index], matrix[1][index], matrix[2][index]);
        }
    }

    @Override
    public void set(int row, int col, float value) {
        if (row > matrix.length - 1 || col > matrix[0].length - 1 || row < 0 || col < 0) {
            throw new IllegalArgumentException("Что что ты хочешь сделать с матрицей 3на3");
        } else {
            matrix[row][col] = value;
        }
    }

    @Override
    public void setRow(int index, float[] values) {
        if (index < 0 || index > matrix.length || values.length != matrix.length) {
            throw new IllegalArgumentException("Что что ты хочешь сделать с матрицей 3на3");
        } else {
            for (int i = 0; i < matrix.length; i++) {
                matrix[index][i] = values[i];
            }
        }
    }

    @Override
    public void setCol(int index, float[] values) {
        if (index < 0 || index > matrix.length || values.length != matrix[0].length) {
            throw new IllegalArgumentException("Что что ты хочешь сделать с матрицей 3на3");
        } else {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][index] = values[i];
            }
        }
    }

    @Override
    public Matrix3F getInverse() {
        float det = getDeterminant();
        if (det != 0) {
            Matrix3F complements = getComplement();
            complements.transpose();
            return complements.mult(1 / det);
        } else {
            return null;
        }
    }

    @Override
    public Matrix3F getComplement() {
        float[][] complement = new float[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                float subs = getDeterminant2Dim(getMatrixToSubstitute(i, j));
                if ((i + j) % 2 == 0) {
                    complement[i][j] = subs;
                } else {
                    complement[i][j] = -1 * subs;
                }
            }
        }
        return new Matrix3F(complement);
    }

    @Override
    public Vector3F gaussSolution(Vector b) {
        if (b instanceof Vector3F) {
            if (Math.abs(getDeterminant()) > 0.1e-5) {
                float[] answers = new float[matrix.length];
                float[][] m = new float[matrix.length][matrix[0].length + 1];

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        m[i][j] = matrix[i][j];
                    }
                    m[i][m[0].length - 1] = b.get(i);
                }


                for (int i = 0; i < m.length; i++) {
                    normalizeRows(i, m);
                    for (int j = i + 1; j < m.length; j++) {
                        subRows(i, j, 1, m);
                    }
                }

                for (int i = m.length - 1; i >= 0; i--) {
                    answers[i] = (m[i][m[0].length - 1] - rowSum(i + 1, m[0].length - 2, m[i], answers)) / m[i][i];
                }

                return new Vector3F(answers);
            } else {
                throw new IllegalArgumentException("не буду такое решать, тут либо много решений либо вообще их нет");
            }
        } else {
            throw new IllegalArgumentException("Вектор ответов не той размерности");
        }
    }

    @Override
    public float getDeterminant() {
        float[][] m = cloneMatrix(matrix);
        float ans = 1;
        for (int i = 0; i < m[0].length; i++) {
            for (int j = i; j < m.length; j++) {
                ans *= m[j][i];
            }
            normalizeRows(i, m);
            for (int j = i + 1; j < matrix.length; j++) {
                subRows(i, j, 1, m);
            }
        }
        return ans;
    }

    private float rowSum(int start, int end, float[] r, float[] answers) {
        if (end - start >= 0) {
            float sum = 0;
            for (int i = start; i <= end; i++) {
                sum += r[i] * answers[i];
            }
            return sum;
        } else {
            return 0;
        }
    }

    private float getDeterminant2Dim(float[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    private float[][] getMatrixToSubstitute(int row, int col) {
        float[][] m = new float[matrix.length - 1][matrix.length - 1];
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i != row) {
                for (int j = 0; j < matrix.length; j++) {
                    if (j != col) {
                        m[r][c] = matrix[i][j];
                        c++;
                    }
                }
                c = 0;
                r++;
            }
        }
        return m;
    }

    private void normalizeRows(int col, float[][] m) {
        for (int i = col; i < m.length; i++) {
            for (int j = m[0].length - 1; j >= col; j--) {
                m[i][j] /= m[i][col];
            }
        }
    }

    private void subRows(int rowToSub, int subbedRow, int amount, float[][] m) {
        for (int i = 0; i < m[0].length; i++) {
            m[subbedRow][i] -= amount * m[rowToSub][i];
        }
    }

    private float[][] cloneMatrix(float[][] m) {
        float[][] newM = new float[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            newM[i] = m[i].clone();
        }
        return newM;
    }

    @Override
    public boolean compareTo(Matrix m) {
        if (m instanceof Matrix3F) {
            boolean similar = true;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (Math.abs(m.get(i, j) - matrix[i][j]) > 0.1e-5) {
                        similar = false;
                        return similar;
                    }
                }
            }
            return similar;
        } else {
            throw new IllegalArgumentException("Матрицы разных размерностей");
        }
    }
}
