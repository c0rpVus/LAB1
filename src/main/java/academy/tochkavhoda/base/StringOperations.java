package academy.tochkavhoda.base;

import java.util.Arrays;

public class StringOperations {

        public static int getSummaryLength(String[] strings) {
            int totalLength = 0;
            for (String str : strings) {
                totalLength += str.length();
            }
            return totalLength;
        }

        public static String getFirstAndLastLetterString(String string) {
            if (string == null || string.isEmpty()) {
                return "";
            }
            return String.valueOf(string.charAt(0)) + string.charAt(string.length() - 1);
        }

        public static boolean isSameCharAtPosition(String string1, String string2, int index) {
            if (string1 == null || string2 == null ||
                    index < 0 || index >= string1.length() || index >= string2.length()) {
                return false;
            }
            return string1.charAt(index) == string2.charAt(index);
        }

        public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
            int pos1 = string1.indexOf(character);
            int pos2 = string2.indexOf(character);
            return pos1 == pos2 && pos1 != -1;
        }

        public static boolean isSameLastCharPosition(String string1, String string2, char character) {
            int pos1 = string1.lastIndexOf(character);
            int pos2 = string2.lastIndexOf(character);
            return pos1 == pos2 && pos1 != -1;
        }

        public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
            int pos1 = string1.indexOf(str);
            int pos2 = string2.indexOf(str);
            return pos1 == pos2 && pos1 != -1;
        }

        public static boolean isSameLastStringPosition(String string1, String string2, String str) {
            int pos1 = string1.lastIndexOf(str);
            int pos2 = string2.lastIndexOf(str);
            return pos1 == pos2 && pos1 != -1;
        }

        public static boolean isEqual(String string1, String string2) {
            return string1.equals(string2);
        }

        public static boolean isEqualIgnoreCase(String string1, String string2) {
            return string1.equalsIgnoreCase(string2);
        }

        public static boolean isLess(String string1, String string2) {
            return string1.compareTo(string2) < 0;
        }

        public static boolean isLessIgnoreCase(String string1, String string2) {
            return string1.compareToIgnoreCase(string2) < 0;
        }

        public static String concat(String string1, String string2) {
            return string1 + string2;
        }

        public static boolean isSamePrefix(String string1, String string2, String prefix) {
            return string1.startsWith(prefix) && string2.startsWith(prefix);
        }

        public static boolean isSameSuffix(String string1, String string2, String suffix) {
            return string1.endsWith(suffix) && string2.endsWith(suffix);
        }

        public static String getCommonPrefix(String string1, String string2) {
            int minLength = Math.min(string1.length(), string2.length());
            StringBuilder prefix = new StringBuilder();

            for (int i = 0; i < minLength; i++) {
                if (string1.charAt(i) == string2.charAt(i)) {
                    prefix.append(string1.charAt(i));
                } else {
                    break;
                }
            }
            return prefix.toString();
        }

        public static String reverse(String string) {
            return new StringBuilder(string).reverse().toString();
        }

        public static boolean isPalindrome(String string) {
            int left = 0;
            int right = string.length() - 1;

            while (left < right) {
                if (string.charAt(left) != string.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        public static boolean isPalindromeIgnoreCase(String string) {
            return isPalindrome(string.toLowerCase());
        }

        public static String getLongestPalindromeIgnoreCase(String[] strings) {
            String longestPalindrome = "";

            for (String str : strings) {
                if (isPalindromeIgnoreCase(str) && str.length() > longestPalindrome.length()) {
                    longestPalindrome = str;
                }
            }
            return longestPalindrome;
        }

        public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
            if (index < 0 || length < 0 ||
                    index + length > string1.length() ||
                    index + length > string2.length()) {
                return false;
            }

            String substr1 = string1.substring(index, index + length);
            String substr2 = string2.substring(index, index + length);
            return substr1.equals(substr2);
        }

        public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                            String string2, char replaceInStr2, char replaceByInStr2) {
            String result1 = string1.replace(replaceInStr1, replaceByInStr1);
            String result2 = string2.replace(replaceInStr2, replaceByInStr2);
            return result1.equals(result2);
        }

        public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                         String string2, String replaceInStr2, String replaceByInStr2) {
            String result1 = string1.replace(replaceInStr1, replaceByInStr1);
            String result2 = string2.replace(replaceInStr2, replaceByInStr2);
            return result1.equals(result2);
        }

        public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
            String withoutSpaces = string.replace(" ", "");
            return isPalindromeIgnoreCase(withoutSpaces);
        }

        public static boolean isEqualAfterTrimming(String string1, String string2) {
            return string1.trim().equals(string2.trim());
        }

        public static String makeCsvStringFromInts(int[] array) {
            if (array == null || array.length == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i < array.length - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        public static String makeCsvStringFromDoubles(double[] array) {
            if (array == null || array.length == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(String.format("%.2f", array[i]));
                if (i < array.length - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
            if (array == null || array.length == 0) {
                return new StringBuilder();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i < array.length - 1) {
                    sb.append(",");
                }
            }
            return sb;
        }

        public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
            if (array == null || array.length == 0) {
                return new StringBuilder();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(String.format("%.2f", array[i]));
                if (i < array.length - 1) {
                    sb.append(",");
                }
            }
            return sb;
        }

        public static StringBuilder removeCharacters(String string, int[] positions) {
            if (positions == null || positions.length == 0) {
                return new StringBuilder(string);
            }

            StringBuilder sb = new StringBuilder(string);
            // Удаляем с конца, чтобы индексы не сдвигались
            for (int i = positions.length - 1; i >= 0; i--) {
                sb.deleteCharAt(positions[i]);
            }
            return sb;
        }

        public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
            if (positions == null || characters == null || positions.length != characters.length) {
                return new StringBuilder(string);
            }

            StringBuilder sb = new StringBuilder(string);
            // Вставляем с начала, учитывая сдвиг индексов
            for (int i = 0; i < positions.length; i++) {
                sb.insert(positions[i] + i, characters[i]);
            }
            return sb;
        }
}


