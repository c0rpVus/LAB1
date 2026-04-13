package academy.tochkavhoda.introduction;

import java.util.Random;

public class ZeroSteps2 {

    public int sumSquares(int count) {
        return count * (count + 1) * (2 * count + 1) / 6;
    }

    public int sumOdds(int count) {
        int k = (count + 1) / 2;
        return k * k;
    }

    public double sumInverses(int count) {
        double sum = 0.0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public long factorial(int count) {
        long res = 1L;
        for (int i = 1; i <= count; i++) {
            res *= i;
        }
        return res;
    }

    public int prodDigits(int value) {
        int n = Math.abs(value);
        if (n == 0) return 0;
        int prod = 1;
        while (n > 0) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }

    public int fibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= number; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public long sum2Powers(int max) {
        // sum 2^0 .. 2^max = 2^{max+1} - 1
        return (1L << (max + 1)) - 1L;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
            if (sum > barrier) break;
        }
        return sum;
    }

    public int sumPairProd(int count1, int count2) {
        int sum1 = count1 * (count1 + 1) / 2;
        int sum2 = count2 * (count2 + 1) / 2;
        return sum1 * sum2;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int prod = i * j;
                if (prod < barrier) sum += prod;
            }
        }
        return sum;
    }

    public double sumInversePairProd(int count1, int count2) {
        double sum = 0.0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }

    public int sumTripleProd(int count1, int count2, int count3) {
        long s1 = (long) count1 * (count1 + 1) / 2;
        long s2 = (long) count2 * (count2 + 1) / 2;
        long s3 = (long) count3 * (count3 + 1) / 2;
        long total = s1 * s2 * s3;
        return (int) total; // match expected int overflow behavior
    }

    public double calculateE() {
        double sum = 1.0;
        double term = 1.0;
        int i = 1;
        while (true) {
            term /= i;
            if (term < 1E-6) break;
            sum += term;
            i++;
        }
        return sum;
    }

    public double calculatePi() {
        double sum = 0.0;
        double denom = 1.0;
        int sign = 1;
        while (Math.abs(4.0 / denom) >= 1E-8) {
            sum += sign * (4.0 / denom);
            denom += 2.0;
            sign = -sign;
        }
        return sum;
    }

    public double calculateCircleSquare(double length, int count) {
        Random rnd = new Random();
        int inside = 0;
        double r = length / 2.0;
        double r2 = r * r;
        double cx = r;
        double cy = r;
        for (int i = 0; i < count; i++) {
            double x = rnd.nextDouble() * length;
            double y = rnd.nextDouble() * length;
            double dx = x - cx;
            double dy = y - cy;
            if (dx * dx + dy * dy <= r2) inside++;
        }
        return length * length * ((double) inside / count);
    }
}