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

// Time -> O(1) //
// Space -> O(n) //

class LRUCache {
    private class ListNode {
        private ListNode prev;
        private ListNode next;
        private int key;
        private int value;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private ListNode head = new ListNode(0, 0);
    private ListNode tail = new ListNode(0, 0);
    private HashMap<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>();

        head.next = tail;
        tail.prev = head;
    }

    private void insert(ListNode node) {
        map.put(node.key, node);

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(ListNode node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
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

        insert(new ListNode(key, value));
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 10);
        lruCache.put(3, 7);
        lruCache.put(2, 21);

        System.out.println(lruCache.get(3));

        lruCache.put(4, 73);

        System.out.println(lruCache.get(2));

        lruCache.put(4, 47);

        System.out.println(lruCache.get(4));
    }
}