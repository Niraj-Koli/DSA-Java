class SinglyLinkedList {
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

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

    // Time -> O(n) //
    // Space -> O(1) //

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

    private static int lengthOfLL(ListNode head) {
        ListNode temp = head;

        int length = 0;

        while (temp != null) {
            temp = temp.next;
            length++;
        }

        return length;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static boolean search(ListNode head, int value) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = null;

        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };

        ListNode head = convertArrayToLL(arr);
        printLL(head);

        System.out.println(search(head, 2));
        System.out.println(lengthOfLL(head));

        ListNode newHead = reverse(head);
        printLL(newHead);
    }
}
