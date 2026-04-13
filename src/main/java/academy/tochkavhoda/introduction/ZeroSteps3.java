package academy.tochkavhoda.introduction;

public class ZeroSteps3 {

    public int sum(int[] array) {
        if (array == null || array.length == 0) return 0;
        int s = 0;
        for (int v : array) s += v;
        return s;
    }

    public int mul(int[] array) {
        if (array == null || array.length == 0) return 0;
        int p = 1;
        for (int v : array) p *= v;
        return p;
    }

    public int min(int[] array) {
        if (array == null || array.length == 0) return Integer.MAX_VALUE;
        int m = array[0];
        for (int v : array) if (v < m) m = v;
        return m;
    }

    public int max(int[] array) {
        if (array == null || array.length == 0) return Integer.MIN_VALUE;
        int m = array[0];
        for (int v : array) if (v > m) m = v;
        return m;
    }

    public double average(int[] array) {
        if (array == null || array.length == 0) return 0;
        return sum(array) / (double) array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        if (array == null || array.length <= 1) return true;
        for (int i = 1; i < array.length; i++) {
            if (!(array[i - 1] > array[i])) return false; // строго убывает
        }
        return true;
    }

    public void cube(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        if (array == null) return false;
        for (int v : array) if (v == value) return true;
        return false;
    }

    public void reverse(int[] array) {
        if (array == null) return;
        int i = 0, j = array.length - 1;
        while (i < j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++; j--;
        }
    }

    public boolean isPalindrome(int[] array) {
        if (array == null || array.length <= 1) return true;
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] != array[j]) return false;
            i++; j--;
        }
        return true;
    }

    public void replaceBySquare(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) break;
            array[i] = array[i] * array[i];
        }
    }

    public int mulNonZero(int[] array) {
        if (array == null || array.length == 0) return 0;
        int prod = 1;
        boolean any = false;
        for (int v : array) {
            if (v != 0) {
                prod *= v;
                any = true;
            }
        }
        return any ? prod : 0;
    }

    public boolean allPositive(int[] array) {
        if (array == null || array.length == 0) return false;
        for (int v : array) if (v <= 0) return false;
        return true;
    }

    public boolean allEqual(int[] array) {
        if (array == null || array.length == 0) return true;
        int first = array[0];
        for (int v : array) if (v != first) return false;
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
        final double EPS = 1E-9;
        for (int i = 1; i < array.length - 1; i++) {
            double avg = (array[i - 1] + array[i + 1]) / 2.0;
            if (Math.abs(array[i] - avg) < EPS) return true;
        }
        return false;
    }

    public int sumBetween2Zeros(int[] array) {
        if (array == null || array.length == 0) return 0;
        int first = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) { first = i; break; }
        }
        if (first == -1) return 0;
        int second = -1;
        for (int i = first + 1; i < array.length; i++) {
            if (array[i] == 0) { second = i; break; }
        }
        if (second == -1 || second - first <= 1) return 0;
        int sum = 0;
        for (int i = first + 1; i < second; i++) sum += array[i];
        return sum;
    }

    public int sameAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) return 0;
        int len = Math.min(array1.length, array2.length);
        int cnt = 0;
        for (int i = 0; i < len; i++) if (array1[i] == array2[i]) cnt++;
        return cnt;
    }

    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) return false;
        int len = Math.min(array1.length, array2.length);
        for (int i = 0; i < len; i++) if (array1[i] == 0 && array2[i] == 0) return true;
        return false;
    }

    public void accumulatedSum(int[] array) {
        if (array == null || array.length == 0) return;
        int run = 0;
        for (int i = 0; i < array.length; i++) {
            run += array[i];
            array[i] = run;
        }
    }

    public int[] mergeArrays(int[] array1, int[] array2) {
        if (array1 == null) array1 = new int[0];
        if (array2 == null) array2 = new int[0];
        int n = array1.length, m = array2.length;
        int[] res = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (array1[i] <= array2[j]) res[k++] = array1[i++];
            else res[k++] = array2[j++];
        }
        while (i < n) res[k++] = array1[i++];
        while (j < m) res[k++] = array2[j++];
        return res;
    }

    public int insideCircle(int[] x, int[] y, int radius) {
        if (x == null || y == null) return 0;
        int len = Math.min(x.length, y.length);
        long r2 = (long) radius * radius;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            long dx = x[i];
            long dy = y[i];
            if (dx * dx + dy * dy <= r2) cnt++;
        }
        return cnt;
    }

    public double scalarProduct(double[] array1, double[] array2) {
        if (array1 == null || array2 == null) return 0;
        int len = Math.min(array1.length, array2.length);
        double sum = 0.0;
        for (int i = 0; i < len; i++) sum += array1[i] * array2[i];
        return sum;
    }
}