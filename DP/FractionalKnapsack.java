/*
 * Given weights and values of N items, we need to put these items in a knapsack
 * of capacity W to get the maximum total value in the knapsack.
 * Note: Unlike 0/1 knapsack, you are allowed to break the item here.
 */

import java.util.Arrays;

public class FractionalKnapsack {
    private static class Item {
        private int value;
        private int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    // Time -> O(n * log(n)) //
    // Space -> O(1) //

    private static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (item1, item2) -> Double.compare((double) item2.value / item2.weight,
                (double) item1.value / item1.weight));

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += fraction * item.value;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        int n = values.length;

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        System.out.println(fractionalKnapsack(items, capacity));
    }
}