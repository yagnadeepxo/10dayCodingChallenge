
import java.util.ArrayList;
import java.util.List;


// using iteration.

/* the generate function takes in the number of rows and prints that many
 * rows of the triangle
*/

public class Iteration {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0||j==i){
                    list.add(1);
                }
                else{
                    int a = res.get(i-1).get(j-1);
                    int b = res.get(i-1).get(j);
                    list.add(a+b);
                }
                
            }
            res.add(list);
        }
        return res;
    }

}


//output

/*
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 

 */





/* 
 * 
 * simple explanation of the code:

The main function is the entry point of the program. It prints the result of generating Pascal's triangle with 5 rows by calling the generate method and passing 5 as the argument.

The generate method takes an integer numRows as input and returns Pascal's triangle as a list of lists (List<List<Integer>>).

The method initializes an empty list res to store the rows of Pascal's triangle.

It then iterates from i = 0 to numRows - 1 to generate each row of the triangle.

For each row, a new list is created to store the numbers of that row.

The inner loop iterates from j = 0 to i, representing the elements within each row.

If j is 0 or j is equal to i, it means we are at the first or last element of the row, which should always be 1. So, in that case, 1 is added to the list.

Otherwise, for elements in between the first and last, the method retrieves the corresponding values from the previous row in the res list. The values are added together (a + b) and then added to the list.

After the inner loop finishes, the list representing the current row is added to the res list.

Once the outer loop completes, all the rows of Pascal's triangle have been generated, and the res list is returned as the result.

*/
