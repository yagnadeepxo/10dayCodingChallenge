import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        generateRows(numRows, res);
        return res;
    }

    private static void generateRows(int numRows, List<List<Integer>> triangle) {
        if (numRows == 0) {
            return;
        }

        generateRows(numRows - 1, triangle);

        List<Integer> currRow = new ArrayList<>();
        if (numRows == 1) {
            currRow.add(1);
        } else {
            List<Integer> prevRow = triangle.get(numRows - 2);
            currRow.add(1);
            for (int i = 1; i < numRows - 1; i++) {
                int num = prevRow.get(i - 1) + prevRow.get(i);
                currRow.add(num);
            }
            currRow.add(1);
        }
        triangle.add(currRow);
    }
}

/*
 * In this recursive approach, the generateRows method is called recursively with numRows decremented by 1 each time until it reaches 0, which serves as the base case.

During the recursive calls, the method generates the previous rows first by calling generateRows(numRows - 1, triangle). This ensures that the previous rows are already populated in the triangle list.

After the recursive call, a new currRow is created. If numRows is 1, indicating the first row, we simply add the number 1 to currRow. Otherwise, we calculate the elements of the current row by accessing the previous row from triangle, similar to the iterative approach.

Finally, the currRow is added to the triangle list.
 */