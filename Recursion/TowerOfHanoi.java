/*
 * The tower of Hanoi is a famous puzzle where we have three rods and N disks.
 * The objective of the puzzle is to move the entire stack to another rod. You
 * are given the number of discs N. Initially, these discs are in the rod 1. You
 * need to print all the steps of discs movement so that all the discs reach the
 * 3rd rod. Also, you need to find the total moves.
 * Note: The discs are arranged such that the top disc is numbered 1 and the
 * bottom-most disc is numbered N. Also, all the discs have different sizes and
 * a bigger disc cannot be put on the top of a smaller disc. Refer the provided
 * link to get a better clarity about the puzzle.
 */

/* 
   n -> No of plates
   s -> source 
   d -> destination
   h -> helper 
   count -> No of steps
   
*/

class TowerOfHanoi {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static int count = 0;

    private static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        count++;

        if (n == 1) {
            System.out.println("Move disc 1 from rod " + source + " to rod " + destination);
            return;
        }

        towerOfHanoi(n - 1, source, auxiliary, destination);

        System.out.println("Move disc " + n + " from rod " + source + " to rod " + destination);

        towerOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int n = 3;

        towerOfHanoi(n, '1', '3', '2');

        System.out.println(count);
    }
}