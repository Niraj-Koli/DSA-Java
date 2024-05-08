class DoublyLinkedList {
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

    // Time -> O(n) //
    // Space -> O(n) //

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

    // Time -> O(n) //
    // Space -> O(1) //

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

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {
            prevNode = temp.prev;
            temp.prev = temp.next;
            temp.next = prevNode;
            temp = temp.prev;
        }

        return prevNode.prev;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };

        ListNode head = convertArrayToDLL(arr);
        printDLL(head);

        ListNode newHead = reverse(head);
        printDLL(newHead);
    }
}
