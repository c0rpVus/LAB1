package academy.tochkavhoda.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class NumberOperations {
    public static Integer find(int[] array, int value) {
        if (array == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        if (array == null || eps < 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps) {
                return i;
            }
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        if (volume == 0 || min > max) {
            return null;
        }

        double density = weight / volume;

        if (density >= min && density <= max) {
            return density;
        }
        return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        if (array == null || value == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(value)) {
                return i;
            }
        }
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume,
                                              BigDecimal min, BigDecimal max) {
        if (weight == null || volume == null || min == null || max == null) {
            return null;
        }

        if (volume.compareTo(BigDecimal.ZERO) == 0 || min.compareTo(max) > 0) {
            return null;
        }

        try {
            // Вычисляем плотность с 10 знаками после запятой
            BigDecimal density = weight.divide(volume, 10, RoundingMode.HALF_UP);

            // Проверяем, находится ли плотность в заданном диапазоне
            if (density.compareTo(min) >= 0 && density.compareTo(max) <= 0) {
                // Убираем лишние нули в дробной части
                return density.stripTrailingZeros();
            }
            return null;

        } catch (ArithmeticException e) {
            return null;
        }
    }


}
