/*
 * Design a data structure to store the strings' count with the ability to
 * return the strings with minimum and maximum counts.
 * 
 * Implement the AllOne class:
 * 
 * AllOne() Initializes the object of the data structure.
 * inc(String key) Increments the count of the string key by 1. If key does not
 * exist in the data structure, insert it with count 1.
 * dec(String key) Decrements the count of the string key by 1. If the count of
 * key is 0 after the decrement, remove it from the data structure. It is
 * guaranteed that key exists in the data structure before the decrement.
 * getMaxKey() Returns one of the keys with the maximal count. If no element
 * exists, return an empty string "".
 * getMinKey() Returns one of the keys with the minimum count. If no element
 * exists, return an empty string "".
 * Note that each function must run in O(1) average time complexity.
 */

import java.util.HashMap;
import java.util.HashSet;

class AllOne {
    private static class ListNode {
        int frequency;
        ListNode prev;
        ListNode next;
        HashSet<String> set;

        public ListNode(int frequency) {
            this.frequency = frequency;
            this.prev = null;
            this.next = null;
            this.set = new HashSet<String>();
        }
    }

    private ListNode head;
    private ListNode tail;
    private HashMap<String, ListNode> map;

    public AllOne() {
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<String, ListNode>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next.frequency == 1) {
                head.next.set.add(key);
            } else {
                add(head, head.next, key, 1);
            }
            map.put(key, head.next);
        } else {
            ListNode node = map.get(key);

            if (node.frequency + 1 == node.next.frequency) {
                node.next.set.add(key);
            } else {
                add(node, node.next, key, node.frequency + 1);
            }
            node.set.remove(key);
            map.put(key, node.next);

            if (node.set.isEmpty()) {
                delete(node);
            }
        }
    }

    public void dec(String key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            if (node.frequency == 1) {
                map.remove(key);
            } else {
                if (node.frequency - 1 == node.prev.frequency) {
                    node.prev.set.add(key);
                } else {
                    add(node.prev, node, key, node.frequency - 1);
                }
                map.put(key, node.prev);
            }
            node.set.remove(key);
            if (node.set.isEmpty()) {
                delete(node);
            }
        }
    }

    public void add(ListNode node, ListNode next, String key, int count) {
        ListNode newnode = new ListNode(count);
        newnode.set.add(key);
        node.next = newnode;
        newnode.prev = node;
        newnode.next = next;
        next.prev = newnode;
    }

    public void delete(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        } else {
            return tail.prev.set.iterator().next();
        }
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.set.iterator().next();
        }
    }
}

public class AllOoneDataStructure {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}

// class AllOne {

// class ListNode {
// int val;
// String key;
// ListNode pre, next;

// public ListNode(int val, String key) {
// this.val = val;
// this.key = key;
// }

// public void remove(ListNode pre, ListNode next) {
// pre.next = next;
// next.pre = pre;
// this.pre = null;
// this.next = null;
// }

// public void add(ListNode pre, ListNode next) {
// this.pre = pre;
// this.next = next;
// pre.next = this;
// next.pre = this;
// }
// }

// ListNode head, tail;
// HashMap<String, ListNode> map;

// public AllOne() {
// head = new ListNode(0, "");
// tail = new ListNode(0, "");
// head.next = tail;
// tail.pre = head;
// map = new HashMap();
// }

// public void inc(String key) {
// if (!map.containsKey(key)) {
// ListNode node = new ListNode(1, key);
// node.add(head, head.next);
// map.put(key, node);
// return;
// }
// ListNode node = map.get(key);
// node.val++;
// if (node.next == tail)
// return;
// node.remove(node.pre, node.next);
// if (node.val > tail.pre.val)
// node.add(tail.pre, tail);
// else
// node.add(tail.pre.pre, tail.pre);
// }

// public void dec(String key) {
// if (!map.containsKey(key))
// return;
// ListNode node = map.get(key);
// if (--node.val == 0) {
// node.remove(node.pre, node.next);
// map.remove(key);
// return;
// }
// if (node.pre == head)
// return;
// node.remove(node.pre, node.next);
// if (node.val < head.next.val)
// node.add(head, head.next);
// else
// node.add(head.next, head.next.next);
// }

// public String getMaxKey() {
// return tail.pre.key;
// }

// public String getMinKey() {
// return head.next.key;
// }
// }
