package vsu.Task3LinAlg;

public interface Matrix {
    void sum(Matrix m);
    Vector mult(Vector v);
    void mult(Matrix m);
    void transpose();
    float get(int row, int col);
}
