package academy.tochkavhoda.introduction;

public class ZeroSteps4 {

    private final ZeroSteps3 util = new ZeroSteps3();

    public int min(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MAX_VALUE;
        int m = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            if (row == null || row.length == 0) continue;
            int rowMin = util.min(row);
            if (rowMin < m) m = rowMin;
        }
        return m;
    }

    public int max(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int m = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            if (row == null || row.length == 0) continue;
            int rowMax = util.max(row);
            if (rowMax > m) m = rowMax;
        }
        return m;
    }

    public boolean find(int[][] matrix, int value) {
        if (matrix == null) return false;
        for (int[] row : matrix) {
            if (row == null) continue;
            if (util.find(row, value)) return true;
        }
        return false;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        if (matrix == null) return true;
        for (int[] row : matrix) {
            if (!util.isSortedDescendant(row)) return false;
        }
        return true;
    }

    public int hasNoZeroRows(int[][] matrix) {
        if (matrix == null) return 0;
        int count = 0;
        for (int[] row : matrix) {
            boolean hasZero = false;
            if (row != null) {
                for (int v : row) {
                    if (v == 0) { hasZero = true; break; }
                }
            }
            if (!hasZero) count++;
        }
        return count;
    }

    public boolean hasFullZeroRow(int[][] matrix) {
        if (matrix == null) return false;
        for (int[] row : matrix) {
            if (row == null || row.length == 0) continue;
            boolean allZero = true;
            for (int v : row) {
                if (v != 0) { allZero = false; break; }
            }
            if (allZero) return true;
        }
        return false;
    }

    private boolean isSquare(int[][] matrix) {
        if (matrix == null) return false;
        int n = matrix.length;
        if (n == 0) return false;
        for (int[] row : matrix) {
            if (row == null || row.length != n) return false;
        }
        return true;
    }

    public boolean isSymmetric(int[][] matrix) {
        if (!isSquare(matrix)) return false;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) return false;
            }
        }
        return true;
    }

    public int mainDiagonalMax(int[][] matrix) {
        if (!isSquare(matrix)) return Integer.MIN_VALUE;
        int n = matrix.length;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] > m) m = matrix[i][i];
        }
        return m;
    }

    public int mainDiagonalPositivesSum(int[][] matrix) {
        if (!isSquare(matrix)) return 0;
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] > 0) sum += matrix[i][i];
        }
        return sum;
    }

    public int secondaryDiagonalMax(int[][] matrix) {
        if (!isSquare(matrix)) return Integer.MIN_VALUE;
        int n = matrix.length;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int val = matrix[i][n - 1 - i];
            if (val > m) m = val;
        }
        return m;
    }

    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        if (!isSquare(matrix)) return 0;
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int val = matrix[i][n - 1 - i];
            if (val > 0) sum += val;
        }
        return sum;
    }

    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1 == null ? 0 : matrix1.length;
        int rows2 = matrix2 == null ? 0 : matrix2.length;
        int rows = Math.max(rows1, rows2);
        int[][] res = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] r1 = (matrix1 != null && i < matrix1.length) ? matrix1[i] : null;
            int[] r2 = (matrix2 != null && i < matrix2.length) ? matrix2[i] : null;
            int len1 = r1 == null ? 0 : r1.length;
            int len2 = r2 == null ? 0 : r2.length;
            int len = Math.max(len1, len2);
            res[i] = new int[len];
            for (int j = 0; j < len; j++) {
                int v1 = j < len1 ? r1[j] : 0;
                int v2 = j < len2 ? r2[j] : 0;
                res[i][j] = v1 + v2;
            }
        }
        return res;
    }

    public void transpose(int[][] matrix) {
        if (!isSquare(matrix)) return;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void interchange(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;
        for (int i = 0; i + 1 < n; i += 2) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = tmp;
        }
    }

    public int[] toLinearByRow(int[][] matrix) {
        if (matrix == null) return new int[0];
        int total = 0;
        for (int[] row : matrix) if (row != null) total += row.length;
        int[] res = new int[total];
        int idx = 0;
        for (int[] row : matrix) {
            if (row == null) continue;
            for (int v : row) res[idx++] = v;
        }
        return res;
    }

    public int[] toLinearByColumn(int[][] matrix) {
        if (!isSquare(matrix)) return new int[0];
        int n = matrix.length;
        int[] res = new int[n * n];
        int idx = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                res[idx++] = matrix[i][j];
            }
        }
        return res;
    }

    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        if (!isSquare(matrix)) return new int[0];
        int n = matrix.length;
        int total = n * (n + 1) / 2;
        int[] res = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                res[idx++] = matrix[i][j];
            }
        }
        return res;
    }

    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        if (matrix == null) return 0;
        int sum = 0;
        for (int[] row : matrix) {
            if (row == null) continue;
            for (int v : row) {
                if (v == barrier) break;
                sum += v;
            }
        }
        return sum;
    }

    public int sumUntilNotFound(int[][] matrix, int barrier) {
        if (matrix == null) return 0;
        int sum = 0;
        for (int[] row : matrix) {
            if (row == null) continue;
            for (int v : row) {
                if (v == barrier) return sum;
                sum += v;
            }
        }
        return sum;
    }
}