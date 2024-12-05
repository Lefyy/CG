package vsu.Task3LinAlg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {


    @Test
    void sum() {
        float[][] a = new float[][]{{3, 5, 7}, {2, -1, 0}, {4, 3, 2}};
        float[][] b = new float[][]{{1, 2, 4}, {2, 3, -2}, {-1, 0, 1}};
        float[][] c = new float[][]{{4, 7, 11}, {4, 2, -2}, {3, 3, 3}};

        Matrix3F m3f1 = new Matrix3F(a);
        Matrix3F m3f2 = new Matrix3F(b);
        m3f1.sum(m3f2);

        boolean norm = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (m3f1.get(i, j) != c[i][j]) {
                    norm = false;
                }
            }
        }

        Assertions.assertTrue(norm);
    }

    @Test
    void multVector() {
        Matrix3F a = new Matrix3F(new float[][] {{2, 0, 6}, {8, 1, -4}, {0, 5, 7}});
        Vector3F v = new Vector3F(2, 5, -3);

        Vector3F ans = a.mult(v);

        Assertions.assertTrue(ans.get(0) == -14 && ans.get(1) == 33 && ans.get(2) == 4);
    }

    @Test
    void multMatrix() {
        Matrix3F a = new Matrix3F(new float[][] {{9, 3, 5}, {2, 0, 3}, {0, 1, -6}});
        Matrix3F b = new Matrix3F(new float[][] {{1, -1, -1}, {-1, 4, 7}, {8, 1, -1}});

        Matrix3F c = new Matrix3F(new float[][] {{46, 8, 7}, {26, 1, -5}, {-49, -2, 13}});

        Assertions.assertTrue(c.compareTo(a.mult(b)));
    }

    @Test
    void transpose() {
        Matrix3F a = new Matrix3F(new float[][] {{1, 2, 3}, {4, 5 ,6}, {7, 8, 9}});
        Matrix3F b = new Matrix3F(new float[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});

        a.transpose();

        Assertions.assertTrue(b.compareTo(a));
    }

    @Test
    void getDeterminant() {
        Matrix3F a = new Matrix3F(new float[][] {{15, 14, 12}, {6, 7, 1}, {54, 5, 7}});
        float ans = a.getDeterminant();

        Assertions.assertTrue(Math.round(ans) == -3348);
    }

    @Test
    void getInverse() {
        Matrix3F a = new Matrix3F(new float[][]{{2, 5, 7}, {6, 3, 4}, {5, -2, -3}});
        Matrix3F inversedA = new Matrix3F(new float[][]{{1, -1, 1}, {-38, 41, -34}, {27, -29, 24}});
        Matrix3F inversedA2 = a.getInverse();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inversedA2.set(i, j, Math.round(inversedA2.get(i, j)));
            }
        }
        Assertions.assertTrue(inversedA2.compareTo(inversedA));
    }

    @Test
    void gaussSolution() {
        Matrix3F a = new Matrix3F(new float[][] {{4, 2, -1}, {5, 3, -2}, {3, 2, -3}});
        Vector3F b = new Vector3F(1, 2, 0);

        Vector3F ans = a.gaussSolution(b);

        Assertions.assertTrue(Math.round(ans.get(0)) == -1 && Math.round(ans.get(1)) == 3 && Math.round(ans.get(2)) == 1);
    }
}
