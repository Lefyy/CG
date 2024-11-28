package vsu.Task3LinAlg;

public interface Vector {

    void plus(Vector v);
    void minus(Vector v);
    void mult(float a);
    void div(float a);
    float getLength();
    void normalize();
    float scalMult(Vector v);
    float get(int index);
    void set(int index, float value);

}
