/*
 * Design a time-based key-value data structure that can store multiple values
 * for the same key at different time stamps and retrieve the key's value at a
 * certain timestamp.
 * 
 * Implement the TimeMap class:
 * 
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the
 * value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was
 * called previously, with timestamp_prev <= timestamp. If there are multiple
 * such values, it returns the value associated with the largest timestamp_prev.
 * If there are no values, it returns "".
 */

import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }

        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);

        if (treeMap == null) {
            return "";
        }

        Integer floor = treeMap.floorKey(timestamp);
        if (floor == null) {
            return "";
        }

        return treeMap.get(floor);
    }
}

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }
}

// class TimeMap {

// Map<String, List<Node>> map;

// public TimeMap() {
// map = new HashMap<>();
// }

// public void set(String key, String value, int timestamp) {
// List<Node> values = map.get(key);
// if (values == null) {
// values = new ArrayList<>();
// map.put(key, values);
// }

// values.add(new Node(value, timestamp));
// }

// public String get(String key, int timestamp) {
// if (!map.containsKey(key))
// return "";

// List<Node> values = map.get(key);
// if (values.get(0).timestamp > timestamp)
// return "";

// Node lastNode = values.get(values.size() - 1);
// if (lastNode.timestamp <= timestamp)
// return lastNode.value;

// return values.get(findIdx(values, timestamp)).value;
// }

// private int findIdx(List<Node> values, int target) {
// int left = 0;
// int right = values.size() - 1;
// while (left <= right) {
// int mid = left + (right - left) / 2;
// int curTime = values.get(mid).timestamp;
// if (curTime == target)
// return mid;
// if (curTime < target)
// left = mid + 1;
// else
// right = mid - 1;
// }
// return right;
// }

// private class Node {
// String value;
// int timestamp;

// public Node(String value, int timestamp) {
// this.value = value;
// this.timestamp = timestamp;
// }
// }
// }
