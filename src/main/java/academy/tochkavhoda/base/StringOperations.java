package academy.tochkavhoda.base;

import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;

public final class StringOperations {

    private StringOperations() {}

    public static int getSummaryLength(String[] strings) {
        if (strings == null || strings.length == 0) return 0;
        int sum = 0;
        for (String s : strings) {
            if (s != null) sum += s.length();
        }
        return sum;
    }

    public static String getFirstAndLastLetterString(String string) {
        if (string == null) return "";
        int len = string.length();
        if (len == 0) return "";
        if (len == 1) return "" + string.charAt(0) + string.charAt(0);
        return "" + string.charAt(0) + string.charAt(len - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (string1 == null || string2 == null) return false;
        if (index < 0) return false;
        if (index >= string1.length() || index >= string2.length()) return false;
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        int p1 = string1 == null ? -1 : string1.indexOf(character);
        int p2 = string2 == null ? -1 : string2.indexOf(character);
        return p1 == p2;
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        int p1 = string1 == null ? -1 : string1.lastIndexOf(character);
        int p2 = string2 == null ? -1 : string2.lastIndexOf(character);
        return p1 == p2;
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        if (str == null) return string1 == null && string2 == null;
        int p1 = string1 == null ? -1 : string1.indexOf(str);
        int p2 = string2 == null ? -1 : string2.indexOf(str);
        return p1 == p2;
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        if (str == null) return string1 == null && string2 == null;
        int p1 = string1 == null ? -1 : string1.lastIndexOf(str);
        int p2 = string2 == null ? -1 : string2.lastIndexOf(str);
        return p1 == p2;
    }

    public static boolean isEqual(String string1, String string2) {
        return Objects.equals(string1, string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        if (string1 == null && string2 == null) return false;
        if (string1 == null) return true;
        if (string2 == null) return false;
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        if (string1 == null && string2 == null) return false;
        if (string1 == null) return true;
        if (string2 == null) return false;
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        String s1 = string1 == null ? "" : string1;
        String s2 = string2 == null ? "" : string2;
        return s1 + s2;
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        if (prefix == null) return string1 == null && string2 == null;
        if (string1 == null || string2 == null) return false;
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        if (suffix == null) return string1 == null && string2 == null;
        if (string1 == null || string2 == null) return false;
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        if (string1 == null || string2 == null) return "";
        int n = Math.min(string1.length(), string2.length());
        int i = 0;
        while (i < n && string1.charAt(i) == string2.charAt(i)) i++;
        return string1.substring(0, i);
    }

    public static String reverse(String string) {
        if (string == null) return "";
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        if (string == null) return false;
        int len = string.length();
        for (int i = 0; i < len / 2; i++) {
            if (string.charAt(i) != string.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        if (string == null) return false;
        return isPalindrome(string.toLowerCase(Locale.ROOT));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        if (strings == null || strings.length == 0) return "";
        String best = "";
        for (String s : strings) {
            if (s == null) continue;
            if (isPalindromeIgnoreCase(s)) {
                if (s.length() > best.length()) best = s;
            }
        }
        return best;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (string1 == null || string2 == null) return false;
        if (index < 0 || length < 0) return false;
        if (index + length > string1.length() || index + length > string2.length()) return false;
        return string1.regionMatches(index, string2, index, length);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                         String string2, char replaceInStr2, char replaceByInStr2) {
        String s1 = string1 == null ? null : string1.replace(replaceInStr1, replaceByInStr1);
        String s2 = string2 == null ? null : string2.replace(replaceInStr2, replaceByInStr2);
        return Objects.equals(s1, s2);
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2) {
        String s1 = string1 == null ? null : string1.replace(replaceInStr1, replaceByInStr1);
        String s2 = string2 == null ? null : string2.replace(replaceInStr2, replaceByInStr2);
        return Objects.equals(s1, s2);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        if (string == null) return false;
        String noSpaces = string.replace(" ", "");
        return isPalindromeIgnoreCase(noSpaces);
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        if (array == null || array.length == 0) return "";
        StringJoiner joiner = new StringJoiner(",");
        for (int v : array) joiner.add(Integer.toString(v));
        return joiner.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        if (array == null || array.length == 0) return "";
        StringJoiner joiner = new StringJoiner(",");
        for (double v : array) joiner.add(String.format(Locale.ROOT, "%.2f", v));
        return joiner.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        if (array == null || array.length == 0) return sb;
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(',').append(array[i]);
        }
        return sb;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        if (array == null || array.length == 0) return sb;
        sb.append(String.format(Locale.ROOT, "%.2f", array[0]));
        for (int i = 1; i < array.length; i++) {
            sb.append(',').append(String.format(Locale.ROOT, "%.2f", array[i]));
        }
        return sb;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder();
        if (string == null || string.isEmpty()) return sb;
        if (positions == null || positions.length == 0) return new StringBuilder(string);
        int posIdx = 0;
        for (int i = 0; i < string.length(); i++) {
            if (posIdx < positions.length && positions[posIdx] == i) {
                // skip this character
                posIdx++;
            } else {
                sb.append(string.charAt(i));
            }
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder();
        if (string == null) string = "";
        if (positions == null || characters == null || positions.length == 0) return new StringBuilder(string);
        int srcLen = string.length();
        int posIdx = 0;
        for (int i = 0; i <= srcLen; i++) {
            while (posIdx < positions.length && positions[posIdx] == i) {
                sb.append(characters[posIdx]);
                posIdx++;
            }
            if (i < srcLen) sb.append(string.charAt(i));
        }
        return sb;
    }
}
