import java.util.ArrayList;
import java.util.List;

public class Memoization {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] memo = new int[numRows][numRows];
        generateRows(numRows, res, memo);
        return res;
    }

    private static void generateRows(int numRows, List<List<Integer>> triangle, int[][] memo) {
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int value = calculateValue(i, j, memo);
                row.add(value);
            }
            triangle.add(row);
        }
    }

    private static int calculateValue(int i, int j, int[][] memo) {
        if (j == 0 || j == i) {
            return 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int value = calculateValue(i - 1, j - 1, memo) + calculateValue(i - 1, j, memo);
        memo[i][j] = value;
        return value;
    }
}


/*
    here we are solving in recursive manner but in an efficient way where we are using memoization technique.
    we are not recomputing the values twice so we are making it efficient using array data structure
*/