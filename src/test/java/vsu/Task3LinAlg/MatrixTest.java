package vsu.Task3LinAlg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {
    float[][] a = new float[][]{{3, 5, 7}, {2, -1, 0}, {4, 3, 2}};
    float[][] b = new float[][]{{1, 2, 4}, {2, 3, -2}, {-1, 0, 1}};
    float[][] c = new float[][]{{4, 7, 11}, {4, 2, -2}, {3, 3, 3}};

    @Test
    void sum() {
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
}
