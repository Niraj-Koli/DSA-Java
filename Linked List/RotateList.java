/* Given the head of a linked list, rotate the list to the right by k places. */

class RotateList {
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

    private static ListNode findNthNode(ListNode temp, int k) {
        int count = 1;

        while (temp != null) {
            if (count == k) {
                return temp;
            }

            count++;

            temp = temp.next;
        }

        return temp;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        if (k % len == 0) {
            return head;
        }

        k = k % len;

        tail.next = head;

        ListNode newTail = findNthNode(head, len - k);

        head = newTail.next;
        newTail.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 2;

        ListNode head = convertArrayToLL(arr);

        printLL(rotateRight(head, k));
    }
}