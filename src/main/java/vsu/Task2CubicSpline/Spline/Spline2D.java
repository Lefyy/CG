package vsu.Task2CubicSpline.Spline;

import java.util.ArrayList;

public class Spline2D {
    private final ArrayList<Integer> PARAMS = new ArrayList<>();
    private final ArrayList<Float> DS = new ArrayList<>();
    private final Spline SX;
    private final Spline SY;
    public Spline2D(ArrayList<Integer> x, ArrayList<Integer> y) {
        PARAMS.addAll(floatArrayToInt(calcParams(x, y)));
        SX = new Spline(PARAMS, x);
        SY = new Spline(PARAMS, y);
    }

    public int[] getPoint(int param) {
        int x = SX.getPoint(param);
        int y = SY.getPoint(param);
        return new int[] {x, y};
    }

    private ArrayList<Float> calcParams(ArrayList<Integer> x, ArrayList<Integer> y) {
        ArrayList<Integer> dx = getDiff(x);
        ArrayList<Integer> dy = getDiff(y);

        DS.addAll(get2DimDiff(dx, dy));

        ArrayList<Float> S = new ArrayList<>();
        S.add(0.0F);
        S.addAll(getCumSum(DS));

        return S;
    }

    private ArrayList<Integer> getDiff(ArrayList<Integer> array) {
        ArrayList<Integer> diffs = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            diffs.add(array.get(i) - array.get(i - 1));
        }
        return diffs;
    }

    private ArrayList<Float> getCumSum(ArrayList<Float> list) {
        ArrayList<Float> newList = new ArrayList<>();

        newList.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            newList.add(list.get(i) + newList.getLast());
        }

        return newList;
    }
    private ArrayList<Float> get2DimDiff(ArrayList<Integer> dx, ArrayList<Integer> dy) throws IllegalArgumentException {
        if (dx.size() != dy.size()) {
            throw new IllegalArgumentException();
        }

        ArrayList<Float> doubleDimDiff = new ArrayList<>();

        for (int i = 0; i < dx.size(); i++) {
            doubleDimDiff.add((float) Math.sqrt(dx.get(i) * dx.get(i) + dy.get(i) * dy.get(i)));
        }

        return doubleDimDiff;
    }

    private ArrayList<Integer> floatArrayToInt(ArrayList<Float> arr) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (Float f : arr) {
            newList.add(Math.round(f));
        }
        return newList;
    }
}
