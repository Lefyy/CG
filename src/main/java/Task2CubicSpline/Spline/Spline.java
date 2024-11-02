package Task2CubicSpline.Spline;

import java.awt.*;
import java.util.ArrayList;

public class Spline {
    private final ArrayList<Integer> A = new ArrayList<>();
    private final ArrayList<Integer> B = new ArrayList<>();
    private final ArrayList<Integer> C = new ArrayList<>();
    private final ArrayList<Integer> D = new ArrayList<>();
    private final ArrayList<Integer> X = new ArrayList<>();
    private final ArrayList<Integer> Y = new ArrayList<>();
    private final ArrayList<Integer> H = new ArrayList<>();

    public Spline(ArrayList<Integer> x, ArrayList<Integer> y) {
        X.addAll(x);
        Y.addAll(y);

        setH(X);

        A.addAll(Y);
    }

    public void draw(final Graphics gr) {

    }

    private void setH(ArrayList<Integer> X) {
        for (int i = 1; i < X.size(); i++) {
            H.add(X.get(i) - X.get(i - 1));
        }
    }

    private void setC() {
        C.add(0);

        int[][] matrix;
    }

    private int[] solve3DigMatrix(int[][] m) {

    }

    private int[][] setCMatrix() {
        int[][] m = new int[X.size() - 1][X.size() - 2];

        // Первая строка
        m[0][0] = 2 * (H.get(0) + H.get(1));
        m[0][1] = H.get(1);
        m[0][m[0].length - 1] = 3 * ((Y.get(2) - Y.get(1)) / H.get(1) - (Y.get(1) - Y.get(0)) / H.get(0));

        //Вторая - предпоследняя строки
        for (int i = 1; i < m.length - 1; i++) {
            m[i][i-1] = H.get(i);
            m[i][i] = 2 * (H.get(i) + H.get(i + 1));
            m[i][i+1] = H.get(i + 1);
            m[i][m[0].length - 1] = 3 * ((Y.get(i + 2) - Y.get(i + 1)) / H.get(i + 1) - (Y.get(i + 1) - Y.get(i)) / H.get(i));
        }

        //Последняя строка
        m[m.length - 1][m[0].length - 3] = H.get(m.length - 1);
        m[m.length - 1][m[0].length - 2] = 2 * (H.get(m.length - 1) + H.get(m.length));
        m[m.length - 1][m[0].length - 1] = 3 * ((Y.get(m.length + 1) - Y.get(m.length)) / H.get(m.length) - (Y.get(m.length) - Y.get(m.length - 1)) / H.get(m.length - 1));

        return m;
    }
}
