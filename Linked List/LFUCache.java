/*
 * Design and implement a data structure for a Least Frequently Used (LFU)
 * cache.
 * 
 * Implement the LFUCache class:
 * 
 * LFUCache(int capacity) Initializes the object with the capacity of the data
 * structure.
 * int get(int key) Gets the value of the key if the key exists in the cache.
 * Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or
 * inserts the key if not already present. When the cache reaches its capacity,
 * it should invalidate and remove the least frequently used key before
 * inserting a new item. For this problem, when there is a tie (i.e., two or
 * more keys with the same freq), the least recently used key would be
 * invalidated.
 * To determine the least frequently used key, a use counter is maintained for
 * each key in the cache. The key with the smallest use counter is the least
 * frequently used key.
 * 
 * When a key is first inserted into the cache, its use counter is set to 1 (due
 * to the put operation). The use counter for a key in the cache is incremented
 * either a get or put operation is called on it.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 */

import java.util.HashMap;

// Time -> O(1) //
// Space -> O(n) //

class LFUCache {
    private class ListNode {
        private int key;
        private int value;
        private int frequency;
        private ListNode prev;
        private ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private class DoubleLinkedList {
        private int size;
        private ListNode head;
        private ListNode tail;

        public DoubleLinkedList() {
            size = 0;
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(ListNode node) {
            ListNode nextNode = head.next;
            node.next = nextNode;
            node.prev = head;
            head.next = node;
            nextNode.prev = node;
            size++;
        }

        private void removeNode(ListNode node) {
            ListNode prevNode = node.prev;
            ListNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    private int capacity;
    private int curSize;
    private int minFrequency;
    private HashMap<Integer, ListNode> cache;
    private HashMap<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    private void updateNode(ListNode node) {
        int curFrequency = node.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFrequency);
        curList.removeNode(node);

        if (curFrequency == minFrequency && curList.size == 0) {
            minFrequency++;
        }
        node.frequency++;

        DoubleLinkedList newList = frequencyMap.computeIfAbsent(node.frequency, k -> new DoubleLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }

    private int get(int key) {
        ListNode node = cache.get(key);

        if (node == null) {
            return -1;
        }

        updateNode(node);
        return node.value;
    }

    private void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            curSize++;

            if (curSize > capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }

            minFrequency = 1;
            ListNode newNode = new ListNode(key, value);
            DoubleLinkedList curList = frequencyMap.computeIfAbsent(1, k -> new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);

        lfuCache.put(1, 10);
        lfuCache.put(2, 7);
        lfuCache.put(3, 21);

        System.out.println(lfuCache.get(2));

        lfuCache.put(4, 73);

        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));

        lfuCache.put(5, 47);

        System.out.println(lfuCache.get(4));
    }
}