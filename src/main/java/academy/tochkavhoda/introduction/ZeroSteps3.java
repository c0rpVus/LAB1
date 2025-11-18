package academy.tochkavhoda.introduction;

import java.util.Arrays;

public class ZeroSteps3 {

    public int sum(int[] array) {
        if (array == null)
            return 0;

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    public int mul(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int product = 1;
        for (int j : array) {
            product *= j;
        }
        return product;
    }
    public int min(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MAX_VALUE;
        }

        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public int max(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public double average(int[] array) {
        if (array == null || array.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void cube(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        if (array == null) {
            return false;
        }

        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        if (array == null) return;

        for (int i = 0; i < array.length / 2; i++) {
            int j = array.length - 1 - i;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        if (array == null) return true;

        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) return false;
        }
        return true;
    }

    public void replaceBySquare(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                break;
            }
            array[i] = array[i] * array[i];
        }
    }

    public int mulNonZero(int[] array) {
        if (array == null || array.length == 0) return 0;

        int product = 1;
        boolean foundNonZero = false;

        for (int num : array) {
            if (num != 0) {
                product *= num;
                foundNonZero = true;
            }
        }

        return foundNonZero ? product : 0;
    }

    public boolean allPositive(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        return Arrays.stream(array)
                .allMatch(num -> num > 0);
    }

    public boolean allEqual(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        int first = array[0];
        for (int num : array) {
            if (num != first) {
                return false;
            }
        }
        return true;
    }

    public int greaterThanNeighbours(int[] array) {
        if (array == null || array.length < 3) return -1;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) return i;
        }
        return -1;
    }

    public boolean neighboursAverage(double[] array) {
        if (array == null || array.length < 3) return false;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == (array[i - 1] + array[i + 1]) / 2.0) return true;
        }
        return false;
    }

    public int sumBetween2Zeros(int[] array) {
        if (array == null) return 0;

        int firstIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    int sum = 0;
                    for (int j = firstIndex + 1; j < i; j++) {
                        sum += array[j];
                    }
                    return sum;
                }
            }
        }
        return 0;
    }

    public int sameAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return 0;
        }

        int count = 0;
        int minLength = Math.min(array1.length, array2.length);

        for (int i = 0; i < minLength; i++) {
            if (array1[i] == array2[i]) {
                count++;
            }
        }

        return count;
    }

    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }

        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == 0 && array2[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public void accumulatedSum(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int sum = array[0]; // начинаем с первого элемента

        for (int i = 1; i < array.length; i++) {
            sum += array[i]; // добавляем текущий элемент к сумме
            array[i] = sum;  // заменяем текущий элемент накопленной суммой
        }
    }

    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            result[k++] = (array1[i] <= array2[j]) ? array1[i++] : array2[j++];
        }

        while (i < array1.length) result[k++] = array1[i++];
        while (j < array2.length) result[k++] = array2[j++];

        return result;
    }

    public int insideCircle(int[] x, int[] y, int radius) {
        if (x == null || y == null || x.length != y.length) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < x.length; i++) {
            // Вычисляем квадрат расстояния от центра (0,0) до точки (x[i], y[i])
            double distanceSquared = x[i] * x[i] + y[i] * y[i];
            double radiusSquared = radius * radius;

            // Если расстояние <= радиусу (включая точки на окружности)
            if (distanceSquared <= radiusSquared) {
                count++;
            }
        }
        return count;
    }

    public double scalarProduct(double[] array1, double[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return 0.0;
        }

        double sum = 0.0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i];
        }
        return sum;
    }


}
