/*
 * Given the head of a linked list and an integer data, remove all the nodes of
 * the linked list that has ListNode.data == data, and return the new head.
 */

class RemoveLinkedListElements {
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode convertArrayToLL(int[] arr) {
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

    private static void printLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode removeElements(ListNode head, int data) {
        while (head != null && head.data == data) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            if (temp.data == data) {
                if (prev != null) {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1 };
        int value = 2;

        ListNode head = convertArrayToLL(arr);

        printLL(removeElements(head, value));
    }
}