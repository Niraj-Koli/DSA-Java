/*
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();

        ListNode temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);

            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] l1Arr = { 2, 4, 3 };
        int[] l2Arr = { 5, 6, 4 };

        ListNode l1 = convertArrayToLL(l1Arr);
        ListNode l2 = convertArrayToLL(l2Arr);

        ListNode answer = addTwoNumbers(l1, l2);

        printLL(answer);
    }
}


// class Solution {

// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
// ListNode result = new ListNode();
// ListNode current = result;
// int carry = 0;

// while (l1 != null || l2 != null) {
// int x = (l1 != null) ? l1.val : 0;
// int y = (l2 != null) ? l2.val : 0;
// int sum = carry + x + y;

// carry = sum / 10;
// current.next = new ListNode(sum % 10);
// current = current.next;

// if (l1 != null) {
// l1 = l1.next;
// }
// if (l2 != null) {
// l2 = l2.next;
// }
// }

// if (carry > 0) {
// current.next = new ListNode(carry);
// }
// System.gc();
// return result.next;
// }
// }