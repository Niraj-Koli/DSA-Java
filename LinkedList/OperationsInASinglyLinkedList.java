/* Given an array arr[] of size N. The task is to create a linked list from the given array and return the head of the linked list. */

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

public class OperationsInASinglyLinkedList {
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

    public static boolean searchInALL(ListNode head, int target) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int lengthOfLL(ListNode head) {
        ListNode temp = head;

        int length = 0;

        while (temp != null) {
            temp = temp.next;
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 7 };

        ListNode head = convertArrayToLL(arr);

        printLL(head);

        boolean answer = searchInALL(head, 5);

        System.out.println(answer);

        int length = lengthOfLL(head);

        System.out.println("Length = " + length);
    }
}