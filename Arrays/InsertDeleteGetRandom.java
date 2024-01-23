/*
 * Implement the RandomizedSet class:
 * 
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns
 * true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns
 * true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is
 * called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works
 * in average O(1) time complexity
 */

import java.util.HashSet;
import java.util.Random;

class RandomizedSet {
    private HashSet<Integer> randomizedSet;

    public RandomizedSet() {
        randomizedSet = new HashSet<Integer>();
    }

    public boolean insert(int val) {
        if (!randomizedSet.contains(val)) {
            randomizedSet.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (randomizedSet.contains(val)) {
            randomizedSet.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Integer[] arr = randomizedSet.toArray(new Integer[0]);

        Random random = new Random();
        int randomNumber = random.nextInt(randomizedSet.size());

        return arr[randomNumber];
    }
}

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}

// class RandomizedSet {
// private final Random random = new Random();
// private final Map<Integer, Integer> map = new HashMap<>();
// private int[] vals = new int[32];
// private int i = 0;

// public RandomizedSet() {

// }

// public boolean insert(int val) {
// Integer added = map.putIfAbsent(val, i);
// if (added != null)
// return false;

// if (i >= vals.length) {
// vals = Arrays.copyOf(vals, vals.length * 2);
// }
// vals[i++] = val;
// return true;
// }

// public boolean remove(int val) {
// Integer removed = map.remove(val);
// if (removed == null)
// return false;

// if (removed < i - 1) {
// vals[removed] = vals[i - 1];
// map.put(vals[i - 1], removed);
// }
// i--;
// return true;
// }

// public int getRandom() {
// int index = random.nextInt(i);
// return vals[index];
// }
// }
