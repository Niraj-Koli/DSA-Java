/*
 * There are n friends that are playing a game. The friends are sitting in a
 * circle and are numbered from 1 to n in clockwise order. More formally, moving
 * clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i <
 * n, and moving clockwise from the nth friend brings you to the 1st friend.
 * 
 * The rules of the game are as follows:
 * 
 * Start at the 1st friend.
 * Count the next k friends in the clockwise direction including the friend you
 * started at. The counting wraps around the circle and may count some friends
 * more than once.
 * The last friend you counted leaves the circle and loses the game.
 * If there is still more than one friend in the circle, go back to step 2
 * starting from the friend immediately clockwise of the friend who just lost
 * and repeat.
 * Else, the last friend in the circle wins the game.
 * Given the number of friends, n, and an integer k, return the winner of the
 * game.
 */

import java.util.ArrayList;

class JosephusProblem {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static int josephusProblem(ArrayList<Integer> soldiers, int k, int index) {
        int n = soldiers.size();

        if (n == 1) {
            return soldiers.get(0);
        }

        index = (index + (k - 1)) % n;
        soldiers.remove(index);

        return josephusProblem(soldiers, k, index);
    }

    private static int findTheWinner(int n, int k) {
        int index = 0;

        ArrayList<Integer> soldiers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            soldiers.add(i);
        }

        return josephusProblem(soldiers, k, index);
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println(findTheWinner(n, k));
    }
}