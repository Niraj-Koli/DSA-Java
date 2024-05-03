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

// Time -> O(n) //
// Space -> O(n) //

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

class InsertDeleteGetRandom {
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