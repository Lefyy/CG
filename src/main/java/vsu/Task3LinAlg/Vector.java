package vsu.Task3LinAlg;

public interface Vector {

    void sum(Vector v);
    void sub(Vector v);
    void mult(float a);
    void div(float a);
    float getLength();
    void normalize();
    float scalMult(Vector v);

}
