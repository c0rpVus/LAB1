package academy.tochkavhoda.introduction;

public class ZeroSteps4 {

    public int min(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            if (row != null) {
                for (int num : row) {
                    if (num < min) min = num;
                }
            }
        }
        return min;
    }

    public int max(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            if (row != null) {
                for (int num : row) {
                    if (num > max) max = num;
                }
            }
        }
        return max;
    }

    public boolean find(int[][] matrix, int value) {
        if (matrix == null) return false;

        for (int[] row : matrix) {
            if (row != null) {
                for (int num : row) {
                    if (num == value) return true;
                }
            }
        }
        return false;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        if (matrix == null) return true;

        for (int[] row : matrix) {
            if (row != null) {
                for (int i = 1; i < row.length; i++) {
                    if (row[i] >= row[i - 1]) return false;
                }
            }
        }
        return true;
    }

    public int hasNoZeroRows(int[][] matrix) {
        if (matrix == null) return 0;

        int count = 0;
        for (int[] row : matrix) {
            if (row != null) {
                boolean zeroFound = false;
                for (int num : row) {
                    if (num == 0) {
                        zeroFound = true;
                        break;
                    }
                }
                if (!zeroFound) count++;
            }
        }
        return count;
    }

    public boolean hasFullZeroRow(int[][] matrix) {
        if (matrix == null) return false;

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            if (row != null) {
                // Пустая строка не считается строкой из нулей
                if (row.length == 0) {
                    continue;
                }

                boolean allZeros = true;
                for (int num : row) {
                    if (num != 0) {
                        allZeros = false;
                        break;
                    }
                }
                if (allZeros) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSymmetric(int[][] matrix) {
        if (matrix == null) return false;

        int n = matrix.length;

        // Проверяем квадратность
        for (int[] ints : matrix) {
            if (ints == null || ints.length != n) return false;
        }

        // Проверяем симметричность (только элементы выше главной диагонали)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) return false;
            }
        }
        return true;
    }

    public int mainDiagonalMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

        int n = matrix.length;
        for (int[] ints : matrix) {
            if (ints == null || ints.length != n) return Integer.MIN_VALUE;
        }

        int max = matrix[0][0];
        for (int i = 1; i < n; i++) {
            if (matrix[i][i] > max) max = matrix[i][i];
        }
        return max;
    }

    public int mainDiagonalPositivesSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        for (int[] ints : matrix) {
            if (ints == null || ints.length != n) return 0;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] > 0) sum += matrix[i][i];
        }
        return sum;
    }

    public int secondaryDiagonalMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i] == null || matrix[i].length != n) return Integer.MIN_VALUE;
        }

        int max = matrix[0][n - 1];
        for (int i = 1; i < n; i++) {
            int element = matrix[i][n - 1 - i];
            if (element > max) max = element;
        }
        return max;
    }

    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i] == null || matrix[i].length != n) return 0;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int element = matrix[i][n - 1 - i];
            if (element > 0) sum += element;
        }
        return sum;
    }

    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null || matrix1.length != matrix2.length) {
            return new int[0][0];
        }

        int rows = matrix1.length;
        int[][] result = new int[rows][];

        for (int i = 0; i < rows; i++) {
            if (matrix1[i] == null || matrix2[i] == null ||
                    matrix1[i].length != matrix2[i].length) {
                return new int[0][0];
            }

            result[i] = new int[matrix1[i].length];
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public void transpose(int[][] matrix) {
        if (matrix == null) return;

        int n = matrix.length;

        // Проверяем квадратность
        for (int i = 0; i < n; i++) {
            if (matrix[i] == null || matrix[i].length != n) return;
        }

        // Транспонируем (только элементы выше главной диагонали)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void interchange(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length % 2 != 0) {
            return;
        }

        for (int i = 0; i < matrix.length; i += 2) {
            // Меняем местами строку i (четную) и строку i+1 (нечетную)
            int[] temp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = temp;
        }
    }

    public int[] toLinearByRow(int[][] matrix) {
        if (matrix == null) return new int[0];

        // Подсчет общего количества элементов
        int count = 0;
        for (int[] row : matrix) {
            if (row != null) count += row.length;
        }

        // Создание и заполнение результирующего массива
        int[] result = new int[count];
        int index = 0;

        for (int[] row : matrix) {
            if (row != null) {
                for (int num : row) {
                    result[index++] = num;
                }
            }
        }

        return result;
    }

    public int[] toLinearByColumn(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i] == null || matrix[i].length != n) return new int[0];
        }

        int[] result = new int[n * n];
        int index = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                result[index++] = matrix[i][j];
            }
        }

        return result;
    }

    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i] == null || matrix[i].length != n) return new int[0];
        }

        int[] result = new int[n * (n + 1) / 2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                result[idx++] = matrix[i][j];
            }
        }

        return result;
    }

    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        if (matrix == null) return 0;

        int total = 0;
        for (int[] row : matrix) {
            if (row != null) {
                for (int num : row) {
                    if (num == barrier) break;
                    total += num;
                }
            }
        }
        return total;
    }

    public int sumUntilNotFound(int[][] matrix, int barrier) {
        if (matrix == null) return 0;

        int total = 0;
        for (int[] row : matrix) {
            if (row != null) {
                for (int num : row) {
                    if (num == barrier) return total;
                    total += num;
                }
            }
        }
        return total;
    }
}
