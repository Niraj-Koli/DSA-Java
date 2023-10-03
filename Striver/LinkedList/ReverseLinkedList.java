/*
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

// LeetCode //

// class Solution {
// public ListNode reverseList(ListNode head) {
// //throw nodes onto a deque, pop the stack and change ptr

// Deque<ListNode> nodeStack = new ArrayDeque<ListNode>();

// while(head!=null)
// {
// ListNode temp = new ListNode(head.val);
// nodeStack.addFirst(temp);
// head = head.next;
// }
// ListNode node = null;
// ListNode new_head = null;
// while(nodeStack.peekFirst() !=null)
// {
// if(node==null)
// {
// node = nodeStack.removeFirst();
// new_head = node;
// }
// else{
// node.next = nodeStack.removeFirst();
// node = node.next;
// }
// }

// return new_head;

// }
// }
