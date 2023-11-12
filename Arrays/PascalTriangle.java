/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            List<Integer> prevRow = triangle.get(i - 1);

            row.add(1);

            for (int j = 1; j < i; j++) {
                int sum = prevRow.get(j - 1) + prevRow.get(j);

                row.add(sum);
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;

        List<List<Integer>> answer = generate(numRows);

        for (List<Integer> row : answer) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public List<List<Integer>> generate(int numRows) {
// List<List<Integer>> num = new ArrayList<>();
// for (int i = 1; i <= numRows; i++) {
// List<Integer> arr = new ArrayList<>();
// int ans = 1;
// arr.add(1);
// for (int j = 1; j < i; j++) {
// ans = ans * (i - j);
// ans = ans / j;
// arr.add(ans);
// }

// num.add(arr);

// }

// return num;

// }
// }