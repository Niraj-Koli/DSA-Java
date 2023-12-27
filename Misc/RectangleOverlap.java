/*
 * An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where
 * (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the
 * coordinate of its top-right corner. Its top and bottom edges are parallel to
 * the X-axis, and its left and right edges are parallel to the Y-axis.
 * 
 * Two rectangles overlap if the area of their intersection is positive. To be
 * clear, two rectangles that only touch at the corner or edges do not overlap.
 * 
 * Given two axis-aligned rectangles rec1 and rec2, return true if they overlap,
 * otherwise return false.
 */

public class RectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean condition = rec1[2] > rec2[0] && rec1[3] > rec2[1] && rec2[2] > rec1[0] && rec2[3] > rec1[1];

        if (condition) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] rec1 = { 0, 0, 2, 2 };
        int[] rec2 = { 1, 1, 3, 3 };

        boolean answer = isRectangleOverlap(rec1, rec2);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
// return rec1[0] < rec2[2] && rec1[1] < rec2[3] && rec1[2] > rec2[0] && rec1[3]
// > rec2[1];

// }
// }