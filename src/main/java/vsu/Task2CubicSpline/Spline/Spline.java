package vsu.Task2CubicSpline.Spline;

import java.awt.*;
import java.util.ArrayList;

public class Spline {
    private final ArrayList<Float> A = new ArrayList<>();
    private final ArrayList<Float> B = new ArrayList<>();
    private final ArrayList<Float> C = new ArrayList<>();
    private final ArrayList<Float> D = new ArrayList<>();
    private final ArrayList<Integer> X = new ArrayList<>();
    private final ArrayList<Integer> Y = new ArrayList<>();
    private final ArrayList<Float> H = new ArrayList<>();

    public Spline(ArrayList<Integer> x, ArrayList<Integer> y) {
        X.addAll(x);
        Y.addAll(y);
        setH(X);

        //Инициализация коэффициентов
        A.addAll(Y.stream().map(Y -> (float) Y).toList());
        setC();
        setB();
        setD();
    }

    public int getPoint(int param) throws IllegalArgumentException {
        if (param < X.get(0) || param > X.get(X.size() - 1)) {
            throw new IllegalArgumentException();
        }

        int i = searchIndex(param);
        int dx = param - X.get(i);
        int result = (int) (A.get(i) + B.get(i) * dx + C.get(i) * dx * dx + D.get(i) * dx * dx * dx);
        return result;
    }

    private int searchIndex(int x) {
        int leftF = 0;
        int rightF = X.size() - 1;

        while (leftF < rightF) {
            int mid = (leftF + rightF) / 2;
            if (x < X.get(mid)) {
                rightF = mid;
            } else {
                leftF = mid + 1;
            }
        }
        return leftF - 1;
    }

    private void setH(ArrayList<Integer> X) {
        for (int i = 1; i < X.size(); i++) {
            H.add((float) (X.get(i) - X.get(i - 1)));
        }
    }

    private void setB() {
        for (int i = 0; i < H.size() - 1; i++) {
            B.add((float) (Y.get(i + 1) - Y.get(i)) / H.get(i) - H.get(i) / 3 * (C.get(i + 1) + 2 * C.get(i)));
        }
        B.add(0F);
    }

    private void setC() {
        C.add(0F);

        if (H.size() > 2) {
            float[] m = solve3DigMatrix(setCMatrix());
            for (float i : m) {
                C.add(i);
            }
        }

        C.add(0F);
    }

    private void setD() {
        for (int i = 0; i < H.size() - 1; i++) {
            D.add((C.get(i + 1) - C.get(i)) / (3 * H.get(i)));
        }
        D.add(0F);
    }

    private float[] solve3DigMatrix(final float[][] m) {
        float[] u = new float[m.length];
        float[] v = new float[m.length];
        float[] x = new float[m.length];

        //Первая строка нахождения коэф. прогонки
        u[0] = m[0][m[0].length - 1] / m[0][0];
        v[0] = -m[0][1] / m[0][0];

        //Вторая - предпоследняя строки нахождения коэф. прогонки
        for (int i = 1; i < m.length - 1; i++) {
            u[i] = (m[i][m[0].length - 1] - m[i][i - 1] * u[i - 1]) / (m[i][i - 1] * v[i - 1] + m[i][i]);
            v[i] = -m[i][i + 1] / (m[i][i] + m[i][i - 1] * v[i - 1]);
        }


        //Последняя строка нахождения коэф. прогонки
        if (m.length > 1) {
            u[u.length - 1] = (m[m.length - 1][m[0].length - 1] - m[m.length - 1][m.length - 2] * u[u.length - 2]) / (m[m.length - 1][m.length - 2] * v[m.length - 2] + m[m.length - 1][m.length - 1]);
            v[v.length - 1] = 0;
        }

        //Последняя строка ответа
        x[x.length - 1] = u[u.length - 1];

        //Предпоследняя - первая строки ответа
        for (int i = x.length - 2; i > -1; i--) {
            x[i] = v[i] * x[i + 1] + u[i];
        }

        return x;
    }

    private float[][] setCMatrix() {
        float[][] m = new float[H.size() - 2][H.size() - 1];

        // Первая строка
        m[0][0] = 2 * (H.get(0) + H.get(1));
        m[0][1] = H.get(1);
        m[0][m[0].length - 1] = 3 * ((float) (Y.get(2) - Y.get(1)) / H.get(1) - (float) (Y.get(1) - Y.get(0)) / H.get(0));

        //Вторая - предпоследняя строки
        for (int i = 1; i < m.length - 1; i++) {
            m[i][i-1] = H.get(i);
            m[i][i] = 2 * (H.get(i) + H.get(i + 1));
            m[i][i+1] = H.get(i + 1);
            m[i][m[0].length - 1] = 3 * ((float) (Y.get(i + 2) - Y.get(i + 1)) / H.get(i + 1) - (float) (Y.get(i + 1) - Y.get(i)) / H.get(i));
        }

        //Последняя строка
        if (m.length > 1) {
            m[m.length - 1][m[0].length - 3] = H.get(m.length - 1);
            m[m.length - 1][m[0].length - 2] = 2 * (H.get(m.length - 1) + H.get(m.length));
            m[m.length - 1][m[0].length - 1] = 3 * ((float) (Y.get(m.length + 1) - Y.get(m.length)) / H.get(m.length) - (float) (Y.get(m.length) - Y.get(m.length - 1)) / H.get(m.length - 1));
        }

        return m;
    }
}
