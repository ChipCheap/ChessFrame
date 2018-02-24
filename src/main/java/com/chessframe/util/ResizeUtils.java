package com.chessframe.util;

/**
 * ResizeUtils offers commonly used resize values in classes which implement {@link Resizable}.
 */
public class ResizeUtils {
    /**
     * Calculate the default tiny font size from the width and height of the scene.
     *
     * @param width  the width.
     * @param height the height.
     * @return the default tiny font size.
     */
    public static int getTinyFontSize(double width, double height) {
        return (int) Math.min(width * 0.02 * (9 / (double) 16), height * 0.02);
    }

    /**
     * Calculate the default small font size from the width and height of the scene.
     *
     * @param width  the width.
     * @param height the height.
     * @return the default small font size.
     */
    public static int getSmallFontSize(double width, double height) {
        return (int) Math.min(width * 0.03 * (9 / (double) 16), height * 0.03);
    }

    /**
     * Calculate the default normal font size from the width and height of the scene.
     *
     * @param width  the width.
     * @param height the height.
     * @return the default normal font size.
     */
    public static int getNormalFontSize(double width, double height) {
        return (int) Math.min(width * 0.04 * (9 / (double) 16), height * 0.04);
    }

    /**
     * Calculate the default big font size from the width and height of the scene.
     *
     * @param width  the width.
     * @param height the height.
     * @return the default big font size.
     */
    public static int getBigFontSize(double width, double height) {
        return (int) Math.min(width * 0.05 * (9 / (double) 16), height * 0.05);
    }

    /**
     * Calculate the font size of a header from the width and height of the scene.
     *
     * @param width  the width.
     * @param height the height.
     * @return the header font size.
     */
    public static int getHeaderFontSize(double width, double height) {
        return (int) Math.min(width * 0.07 * (9 / (double) 16), height * 0.07);
    }


}
