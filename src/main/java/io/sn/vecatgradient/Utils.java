package io.sn.vecatgradient;


import java.awt.image.BufferedImage;

public class Utils {

    public static StringColor getPixelColor(BufferedImage bi, int x, int y) {
        int r, g, b;
        int pixel = bi.getRGB(x, y);
        r = (pixel & 0xff0000) >> 16;
        g = (pixel & 0xff00) >> 8;
        b = (pixel & 0xff);
        return new StringColor(r, g, b);
    }

    public static String gradientString(String text, BufferedImage bi) {
        StringBuilder sb = new StringBuilder();
        for (String s : text.split(" ")) {
            sb.append(gradientStringWithoutSpace(s, bi)).append(" ");
        }
        return sb.toString();
    }

    public static String gradientStringWithoutSpace(String text, BufferedImage bi) {
        StringBuilder sb = new StringBuilder();
        int imglen = bi.getWidth();
        int s = imglen / text.length();

        for (int i = 0; i < text.length(); i++) {
            int x = ((2 * i + 1) * s) / 2;
            sb.append(getPixelColor(bi, x, 0).toString()).append(text.charAt(i));
        }
        return sb.toString();
    }

    public static String toFullHex(String semiHex) {
        return semiHex.length() == 1 ? "0" + semiHex : semiHex;
    }

    public static String getFullHexCol(int red, int green, int blue) {
        return "#" + toFullHex(Integer.toHexString(red)) + toFullHex(Integer.toHexString(green)) + toFullHex(Integer.toHexString(blue));
    }

}

