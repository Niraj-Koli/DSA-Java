/*
 * Given a doubly linked list of n nodes sorted by values, the task is to remove
 * duplicate nodes present in the linked list.
 */

class RemoveDuplicatesFromASortedDoublyLinkedList {
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data, ListNode next, ListNode prev) {
            this.data = data;
            this.next = next;
        }

        public ListNode(int data) {
            this.data = data;
            this.next = null;
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

    private static ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;

            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;

            if (nextNode != null) {
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3 };

        ListNode head = convertArrayToDLL(arr);

        printDLL(head);

        printDLL(removeDuplicates(head));
    }
}