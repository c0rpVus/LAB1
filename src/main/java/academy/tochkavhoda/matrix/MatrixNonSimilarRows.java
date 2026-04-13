package academy.tochkavhoda.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private final int[][] matrix;
    private final List<RowData> rowDataList;

    public MatrixNonSimilarRows(int[][] matrix) {
        if (matrix == null) {
            this.matrix = new int[0][];
            this.rowDataList = new ArrayList<>();
            return;
        }
        this.matrix = matrix;
        this.rowDataList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            Set<Integer> uniqueNumbers = new HashSet<>();
            if (row != null) {
                for (int num : row) {
                    uniqueNumbers.add(num);
                }
            }
            rowDataList.add(new RowData(i, uniqueNumbers));
        }
    }

    public Set<int[]> getNonSimilarRows() {
        Set<int[]> result = new LinkedHashSet<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        List<RowData> sortedRows = new ArrayList<>(rowDataList);
        sortedRows.sort(Comparator.comparingInt(r -> r.index));

        Set<Set<Integer>> usedSets = new HashSet<>();

        for (RowData rowData : sortedRows) {
            boolean isSimilar = false;
            for (Set<Integer> usedSet : usedSets) {
                if (areSetsEqual(usedSet, rowData.numberSet)) {
                    isSimilar = true;
                    break;
                }
            }

            if (!isSimilar) {
                result.add(matrix[rowData.index]);
                usedSets.add(rowData.numberSet);
            }
        }

        return result;
    }

    private static class RowData {
        int index;
        Set<Integer> numberSet;

        RowData(int index, Set<Integer> numberSet) {
            this.index = index;
            this.numberSet = numberSet;
        }
    }

    private boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() != set2.size()) {
            return false;
        }
        return set1.containsAll(set2);
    }

    public List<Integer> getNonSimilarRowIndices() {
        List<Integer> indices = new ArrayList<>();
        Set<int[]> nonSimilarRows = getNonSimilarRows();

        for (int i = 0; i < matrix.length; i++) {
            for (int[] row : nonSimilarRows) {
                if (Arrays.equals(matrix[i], row)) {
                    indices.add(i);
                    break;
                }
            }
        }

        return indices;
    }

    public void printResult() {
        Set<int[]> result = getNonSimilarRows();
        System.out.println("Непохожие строки:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}