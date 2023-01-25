package io.sn.vecatgradient;

public class MathUtils {

    public static float linearInterpolation(double x, double x1, double x2, float x1value, float x2value) {
        return (float) (((x2 - x) / (x2 - x1) * x1value) + ((x - x1) / (x2 - x1) * x2value));
    }

    public static int gradient(int a, int b, int step, int n) {
        return a + (b - a) * n / step;
    }

}
