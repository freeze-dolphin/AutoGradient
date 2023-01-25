package io.sn.vecatgradient;

import jdk.jshell.execution.Util;

public class StringColor {

    private int red, green, blue;

    public StringColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public StringColor(String str) {
        int r, g, b;
        r = Integer.parseInt(String.valueOf(str.charAt(1) + str.charAt(2)), 16);
        g = Integer.parseInt(String.valueOf(str.charAt(3) + str.charAt(4)), 16);
        b = Integer.parseInt(String.valueOf(str.charAt(5) + str.charAt(6)), 16);
        new StringColor(r % 256, g % 256, b % 256);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "{" + Utils.getFullHexCol(getRed(), getGreen(), getBlue()) + "}";
    }

    public String getColor() {
        return Utils.getFullHexCol(getRed(), getGreen(), getBlue());
    }
}
