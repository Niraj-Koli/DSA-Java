class ReverseADoublyLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode back;

        public ListNode(int val, ListNode next, ListNode back) {
            this.val = val;
            this.next = next;
            this.back = back;
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.back = null;
        }
    }

    public static ListNode convertArrayToDLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
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

    public static ListNode reverseDLL(ListNode head) {
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

        ListNode answer = reverseDLL(head);

        printDLL(answer);
    }
}
