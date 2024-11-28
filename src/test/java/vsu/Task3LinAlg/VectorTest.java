package vsu.Task3LinAlg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorTest {

    @Test
    void plus() {
        Vector3F v3f1 = new Vector3F(1, 2, 3);
        Vector3F v3f2 = new Vector3F(1, 2, 3);
        v3f1.plus(v3f2);
        Assertions.assertTrue(v3f1.get(0) == 2 && v3f1.get(1) == 4 && v3f1.get(2) == 6);
    }

    @Test
    void minus() {
        Vector3F v3f1 = new Vector3F(1, 2, 3);
        Vector3F v3f2 = new Vector3F(1, 2, 3);
        v3f1.minus(v3f2);
        Assertions.assertTrue(v3f1.get(0) == 0 && v3f1.get(1) == 0 && v3f1.get(2) == 0);
    }

    @Test
    void mult() {
        Vector3F v3f1 = new Vector3F(1, 2, 3);
        v3f1.mult(2);
        Assertions.assertTrue(v3f1.get(0) == 2 && v3f1.get(1) == 4 && v3f1.get(2) == 6);
    }

    @Test
    void div() {
        Vector3F v3f1 = new Vector3F(2, 4, 6);
        v3f1.div(2);
        Assertions.assertTrue(v3f1.get(0) == 1 && v3f1.get(1) == 2 && v3f1.get(2) == 3);
    }

    @Test
    void getLength() {
        Vector3F v3f1 = new Vector3F(1, 1, 1);
        Assertions.assertTrue(Math.abs(Math.sqrt(3) - v3f1.getLength()) < 0.1e-5);
    }

    @Test
    void normalize() {
        Vector3F v3f1 = new Vector3F(1, 1, 1);
        v3f1.normalize();
        Assertions.assertTrue(Math.abs(1 / Math.sqrt(3) - v3f1.get(0)) < 0.1e-5);
    }

    @Test
    void scalMult() {
        Vector3F v3f1 = new Vector3F(1, 1, 1);
        Vector3F v3f2 = new Vector3F(1, 1, 1);
        Assertions.assertTrue(3 == v3f1.scalMult(v3f2));
    }

    @Test
    void vecMult() {
        Vector3F v3f1 = new Vector3F(2, -2, -3);
        Vector3F v3f2 = new Vector3F(4, 0, 6);
        Vector3F newVec = v3f1.vecMult(v3f2);
        Assertions.assertTrue(newVec.get(0) == -12 && newVec.get(1) == -24 && newVec.get(2) == 8);
    }
}
