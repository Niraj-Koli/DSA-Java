/*
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 * or false otherwise.
 */

public class PalindromeLinkedList {
    public static ListNode convertArrayToLL(int[] arr) {
        int n = arr.length;

        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < n; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode front;

        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverse(newHead);
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2 };

        ListNode head = convertArrayToLL(arr);

        printLL(head);

        boolean answer = isPalindrome(head);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isPalindrome(ListNode head) {

// ListNode slow = head;
// ListNode fast = head;
// ListNode prev = null;

// while (true) {
// if (fast == null) {
// break;
// }
// if (fast.next == null) {
// slow = slow.next;
// break;
// }
// fast = fast.next.next;

// ListNode temp = slow.next;
// slow.next = prev;
// prev = slow;
// slow = temp;
// }

// while (slow != null) {
// if (prev.val != slow.val)
// return false;
// slow = slow.next;
// prev = prev.next;
// }

// return true;
// }
// }