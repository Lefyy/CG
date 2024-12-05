package vsu.Task3LinAlg;

public interface Matrix {
    void sum(Matrix m);
    Vector mult(Vector v);
    Matrix mult(Matrix m);
    Matrix mult(float a);
    void transpose();
    float get(int row, int col);
    Vector getRow(int index);
    Vector getCol(int index);
    void set(int row, int col, float value);
    void setRow(int index, float[] values);
    void setCol(int index, float[] values);
    Matrix getInverse();
    Matrix getComplement();
    Vector gaussSolution(Vector b);
    float getDeterminant();
    boolean compareTo(Matrix m);
}

// Что логичнее возвращать void или объект класс новый??
// Что делать, если я хочу сделать приватный метод для всех классов, реализующих интерфейс, брать абстрактный класс вместо интерфейса?