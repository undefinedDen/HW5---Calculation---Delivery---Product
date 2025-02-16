package app.util;

import java.text.DecimalFormat;

public class Rounder {
    public static String round(double value) {
        return new DecimalFormat("0.00").format(value);
    }
}
