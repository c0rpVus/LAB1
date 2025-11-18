package academy.tochkavhoda.introduction;

public class ZeroSteps2 {
    public int sumSquares(int count) {
        if (count < 1) {
            throw new ArithmeticException();
        }
        return count * (count + 1) * (2 * count + 1) / 6;
    }

    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i += 2) {
            sum += i;
        }
        return sum;
    }

    public double sumInverses(int count) {
        double sum = 0.0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public long factorial(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
        }
        if (count == 0 || count == 1) {
            return 1;
        }
        return count * factorial(count - 1);
    }

    public int prodDigits(int value) {
        if (value == 0) {
            return 0;
        }

        int product = 1;
        int number = Math.abs(value);

        while (number > 0) {
            int digit = number % 10;
            product *= digit;
            number /= 10;
        }
        return product;
    }

    public int fibonacci(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число Фибоначчи определено только для неотрицательных чисел");
        }
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= number; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public long sum2Powers(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max должен быть неотрицательным");
        }
        // Сумма геометрической прогрессии: 2^(max+1) - 1
        return (1L << (max + 1)) - 1;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            int square = i * i;
            // Добавляем квадрат к сумме
            sum += square;
            // Проверяем, стала ли текущая сумма больше barrier
            if (sum > barrier) {
                break;
            }
        }
        return sum;
    }

    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += i * j;
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
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int product = i * j;
                if (product < barrier) {
                    sum += product;
                } else {
                    // Для фиксированного i, если j слишком велико, прерываем внутренний цикл
                    break;
                }
            }
        }
        return sum;
    }

    public double calculateE() {
        double e = 1.0; // первый элемент ряда: 1
        double term = 1.0; // текущий элемент ряда
        int n = 1; // счетчик для факториала

        while (term >= 1E-6) {
            term /= n; // делим предыдущий член на n, чтобы получить 1/n!
            e += term;
            n++;
        }

        return e;
    }

    public double calculatePi() {
        double pi = 0.0;
        double term = 1.0; // текущий элемент ряда
        int denominator = 1; // знаменатель: 1, 3, 5, 7, ...
        int sign = 1; // знак: +1, -1, +1, -1, ...

        while (Math.abs(term) >= 1E-8) {
            term = (double) sign / denominator;
            pi += term;

            // Подготовка следующего элемента
            denominator += 2;
            sign = -sign; // чередуем знак
        }

        return 4 * pi;
    }

    public double calculateCircleSquare(double length, int count) {
        if (count <= 0 || length <= 0) {
            return 0.0;
        }

        int k = 0; // счетчик точек внутри круга
        double radius = length / 2.0;
        double centerX = length / 2.0;
        double centerY = length / 2.0;

        for (int i = 0; i < count; i++) {
            // Генерируем случайную точку в квадрате [0, length] × [0, length]
            double x = Math.random() * length;
            double y = Math.random() * length;

            // Проверяем, находится ли точка внутри круга
            double distanceSquared = Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2);
            if (distanceSquared <= Math.pow(radius, 2)) {
                k++;
            }
        }

        // Вычисляем площадь круга по формуле
        return length * length * k / count;
    }
}
