/*
 * A conveyor belt has packages that must be shipped from one port to another
 * within days days.
 * 
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we
 * load the ship with packages on the conveyor belt (in the order given by
 * weights). We may not load more weight than the maximum weight capacity of the
 * ship.
 * 
 * Return the least weight capacity of the ship that will result in all the
 * packages on the conveyor belt being shipped within days days.
 */

public class CapacityToShipPackagesWithinDDays {

    // Time -> O(n * log(sum - max + 1))
    // Space -> O(1)

    private static int shippingTime(int[] weights, int capacity) {
        int n = weights.length;

        int currentLoad = 0;
        int daysTaken = 1;

        for (int i = 0; i < n; i++) {
            if (currentLoad + weights[i] > capacity) {
                daysTaken++;
                currentLoad = 0;
            }

            currentLoad += weights[i];
        }

        return daysTaken;
    }

    private static int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int daysTakenForShipping = shippingTime(weights, mid);

            if (daysTakenForShipping <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}