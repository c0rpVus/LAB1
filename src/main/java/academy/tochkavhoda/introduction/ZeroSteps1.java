package academy.tochkavhoda.introduction;

public class ZeroSteps1 {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        if (y != 0){
            return x / y;
        }
        else {
            throw new ArithmeticException();
        }
    }

    public int mod(int x, int y) {
        if (y != 0){
            return x % y;
        }
        else {
            throw new ArithmeticException();
        }
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public double calculateTriangleSquare(int x, int y) {
        return (x * y) / 2.0;
    }

    public double calculateTrianglePerimeter(int x, int y) {
        // Находим гипотенузу по теореме Пифагора
        double hypotenuse = Math.sqrt(x * x + y * y);

        // Периметр = сумма всех сторон
        return x + y + hypotenuse;
    }

    public int reverseNumber(int number) {
        // Извлекаем отдельные цифры числа
        int hundreds = number / 100;        // сотни
        int tens = (number / 10) % 10;      // десятки
        int units = number % 10;            // единицы

        // Формируем обратное число
        return units * 100 + tens * 10 + hundreds;
    }

    public long calculate15Degree(int number) {
        long x = number;

        long x2 = x * x;           // x^2 (1 умножение)
        long x3 = x2 * x;          // x^3 (2 умножения)
        long x6 = x3 * x3;         // x^6 (3 умножения)
        long x12 = x6 * x6;        // x^12 (4 умножения)
        long x15 = x12 * x3;       // x^15 (5 умножений)

        return x15;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    public boolean isTriangleExist(int side1, int side2, int side3) {
        // Проверяем неравенство треугольника для всех трех сторон
        return (side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side2 + side3 > side1);
    }

    public int getDigitsProduction(int number) {
        // Извлекаем отдельные цифры числа
        int digit1 = number / 1000;          // тысячи (первая цифра)
        int digit2 = (number / 100) % 10;    // сотни (вторая цифра)
        int digit3 = (number / 10) % 10;     // десятки (третья цифра)
        int digit4 = number % 10;            // единицы (четвертая цифра)

        // Возвращаем произведение цифр
        return digit1 * digit2 * digit3 * digit4;
    }

    public boolean isCircleInsideSquare(int radius, int side) {
        return 2 * radius < side;
    }

    public char getCharByCode(short code) {
        return (char) code;
    }

    public short getCodeByChar(char character) {
        return (short) character;
    }

    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) (ch + offset);
    }

    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }

    public char getAverageChar(char ch1, char ch2) {
        return (char) ((ch1 + ch2) / 2);
    }
}
