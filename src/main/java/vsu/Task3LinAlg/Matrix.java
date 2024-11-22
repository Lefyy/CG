package vsu.Task3LinAlg;

public interface Matrix {
    void sum(Matrix m);
    void mult(Vector v);
    void mult(Matrix m);
    void transport();
}
