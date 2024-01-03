/*
 * Design a data structure that follows the constraints of a Least Recently Used
 * (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev, next;
    int key, value;

    Node(int _key, int _value) {
        key = _key;
        value = _value;
    }
}

public class LRUCache {
    private int capacity;
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);
    private Map<Integer, Node> map;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        map = new HashMap<Integer, Node>();

        head.next = tail;
        tail.prev = head;
    }

    private void insert(Node node) {
        map.put(node.key, node);

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);

            return node.value;
        } else {
            return -1;
        }
    }

    private void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 10);
        lruCache.put(3, 7);
        lruCache.put(2, 21);
        System.out.println(lruCache.get(3));
        lruCache.put(4, 73);
        lruCache.get(2);
        lruCache.put(4, 47);
        System.out.println(lruCache.get(4));
    }
}

// class LRUCache {
// class Node {
// int key, value;
// Node next, prev;

// Node(int key, int value) {
// this.key = key;
// this.value = value;
// }
// }

// Node head, tail;
// Node[] map;
// int capacity, count;

// public LRUCache(int capacity) {
// this.capacity = capacity;
// count = 0;
// map = new Node[10000 + 1];
// head = new Node(-1, -1);
// tail = new Node(-1, -1);
// head.next = tail;
// tail.prev = head;
// head.prev = null;
// tail.next = null;
// }

// private void deleteNode(Node node) {
// node.prev.next = node.next;
// node.next.prev = node.prev;
// return;
// }

// private void addToTail(Node node) {
// node.prev = tail.prev;
// tail.prev.next = node;
// node.next = tail;
// tail.prev = node;
// return;
// }

// public int get(int key) {
// if (map[key] != null) {
// Node node = map[key];
// deleteNode(node);
// addToTail(node);
// return node.value;
// } else
// return -1;
// }

// public void put(int key, int value) {
// if (map[key] != null) {
// Node updatedNode = map[key];
// updatedNode.value = value;
// deleteNode(updatedNode);
// addToTail(updatedNode);
// } else {
// Node newNode = new Node(key, value);
// map[key] = newNode;
// if (count < capacity) {
// count++;
// addToTail(newNode);
// } else {
// map[head.next.key] = null;
// deleteNode(head.next);
// addToTail(newNode);
// }
// }
// }
// }