class ReverseADoublyLinkedList {
    private static class ListNode {
        private int data;
        private ListNode next;
        private ListNode back;

        public ListNode(int data, ListNode next, ListNode back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    private static ListNode convertArrayToDLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
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

    private static ListNode reverseDLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            prev = temp.back;
            temp.back = temp.next;
            temp.next = prev;
            temp = temp.back;
        }

        return prev.back;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 6, 8, 4 };

        ListNode head = convertArrayToDLL(arr);

        printDLL(head);

        printDLL(reverseDLL(head));
    }
}
