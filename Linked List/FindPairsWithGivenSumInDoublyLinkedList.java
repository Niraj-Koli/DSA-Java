/*
 * Given a sorted doubly linked list of positive distinct elements, the task is
 * to find pairs in a doubly-linked list whose sum is equal to given value
 * target.
 */

import java.util.ArrayList;

class FindPairsWithGivenSumInDoublyLinkedList {
    private static class ListNode {
        private int data;
        private ListNode next;
        private ListNode prev;

        public ListNode(int data, ListNode next, ListNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private static ListNode convertArrayToDLL(int[] arr) {
        int n = arr.length;

        ListNode head = new ListNode(arr[0]);
        ListNode prevNode = head;

        for (int i = 1; i < n; i++) {
            ListNode temp = new ListNode(arr[i], null, prevNode);
            prevNode.next = temp;
            prevNode = temp;
        }

        return head;
    }

    private static void printDLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (head == null) {
            return res;
        }

        ListNode left = head;
        ListNode right = head;

        while (right.next != null) {
            right = right.next;
        }

        while (left.data <= right.data) {
            if (left.data + right.data == target) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(left.data);
                pair.add(right.data);

                res.add(pair);

                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < target) {
                left = left.next;
            } else if (left.data + right.data > target) {
                right = right.prev;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6, 8, 9 };
        int target = 7;

        ListNode head = convertArrayToDLL(arr);

        printDLL(head);

        System.out.println(findPairsWithGivenSum(head, target));
    }
}