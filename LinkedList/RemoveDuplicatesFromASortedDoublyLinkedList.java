/*
 * Given a doubly linked list of n nodes sorted by values, the task is to remove
 * duplicate nodes present in the linked list.
 */

public class RemoveDuplicatesFromASortedDoublyLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static ListNode convertArrayToDLL(int[] arr) {
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

    public static void printDLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;

            while (nextNode != null && nextNode.val == temp.val) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;

            if (nextNode != null) {
                nextNode.prev = temp;
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3 };

        ListNode head = convertArrayToDLL(arr);

        printDLL(head);

        ListNode answer = removeDuplicates(head);

        printDLL(answer);
    }
}