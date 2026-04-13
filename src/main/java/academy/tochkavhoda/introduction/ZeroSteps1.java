package academy.tochkavhoda.introduction;

public class ZeroSteps1 {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public double calculateTriangleSquare(int side1, int side2) {
        return (side1 * side2) / 2.0;
    }

    public double calculateTrianglePerimeter(int side1, int side2) {
        double hypotenuse = Math.sqrt((double) side1 * side1 + (double) side2 * side2);
        return side1 + side2 + hypotenuse;
    }

    public int reverseNumber(int number) {
        int sign = number < 0 ? -1 : 1;
        number = Math.abs(number);
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;
        return sign * (ones * 100 + tens * 10 + hundreds);
    }

    public long calculate15Degree(int number) {
        long n = number;
        long n2 = n * n;           // 1 multiplication
        long n3 = n2 * n;          // 2
        long n5 = n2 * n3;         // 3
        long n10 = n5 * n5;        // 4
        long n15 = n10 * n5;       // 5
        return n15;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs((double) number));
    }

    public boolean isTriangleExist(int side1, int side2, int side3) {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }

    public int getDigitsProduction(int number) {
        int n = Math.abs(number);
        int prod = 1;
        for (int i = 0; i < 4; i++) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
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