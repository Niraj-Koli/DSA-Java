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
import java.util.Map;

public class LFUCache {
    class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList {
        int size;
        Node head;
        Node tail;

        public DoubleLinkedList() {
            size = 0;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node node) {
            Node nextNode = head.next;
            node.next = nextNode;
            node.prev = head;
            head.next = node;
            nextNode.prev = node;
            size++;
        }

        public void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    private int capacity;
    private int curSize;
    private int minFrequency;
    private Map<Integer, Node> cache;
    private Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    private void updateNode(Node node) {
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
        Node node = cache.get(key);

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
            Node node = cache.get(key);
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
            Node newNode = new Node(key, value);
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

// class LFUCache {
// class Node {
// int key;
// int val;
// int cnt = 1;
// Node prev;
// Node next;

// Node(int key, int val) {
// this.key = key;
// this.val = val;
// }
// }

// Node[] keys = new Node[100001];
// Node[] cnts = new Node[200001];
// Node tail;
// int size = 0;
// int capacity;

// public LFUCache(int capacity) {
// this.capacity = capacity;
// }

// void remove(Node node) {
// Node prev = node.prev;
// Node next = node.next;

// if (prev != null)
// prev.next = next;

// if (next != null)
// next.prev = prev;

// keys[node.key] = null;
// if (cnts[node.cnt] == node) {
// if (next != null && next.cnt == node.cnt)
// cnts[node.cnt] = next;
// else
// cnts[node.cnt] = null;
// }

// if (tail == node)
// tail = prev;

// node.prev = null;
// node.next = null;
// }

// void insert(Node node, Node next) {
// cnts[node.cnt] = node;
// keys[node.key] = node;
// if (next == null) {
// if (tail != null)
// tail.next = node;
// node.prev = tail;
// tail = node;
// } else {
// if (next.prev != null)
// next.prev.next = node;
// node.prev = next.prev;
// node.next = next;
// next.prev = node;
// }
// }

// void moveUp(Node node) {
// Node next = cnts[node.cnt + 1] != null ? cnts[node.cnt + 1] : cnts[node.cnt];
// if (next == node)
// next = node.next;

// remove(node);
// node.cnt++;
// insert(node, next);
// }

// public int get(int key) {
// Node node = keys[key];

// if (node == null)
// return -1;

// moveUp(node);

// return node.val;
// }

// public void put(int key, int value) {
// Node node = keys[key];
// if (node == null) {
// node = new Node(key, value);
// if (size >= capacity)
// remove(tail);
// else
// size++;

// insert(node, cnts[1]);
// } else {
// moveUp(node);
// node.val = value;
// }
// }
// }
