package academy.tochkavhoda.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public final class NumberOperations {

    private NumberOperations() {}

    public static Integer find(int[] array, int value) {
        if (array == null) return null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        if (array == null) return null;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps) return i;
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        if (volume == 0) return null;
        double d = weight / volume;
        if (d >= min && d <= max) return d;
        return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        if (array == null || value == null) return null;
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) return i;
        }
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        if (weight == null || volume == null || min == null || max == null) return null;
        if (BigDecimal.ZERO.compareTo(volume) == 0) return null;
        BigDecimal d = weight.divide(volume, 16, RoundingMode.HALF_UP).stripTrailingZeros();
        if (d.compareTo(min) >= 0 && d.compareTo(max) <= 0) return d;
        return null;
    }
}