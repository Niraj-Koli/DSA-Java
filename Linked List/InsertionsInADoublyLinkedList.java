class InsertionsInADoublyLinkedList {
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

    // Time -> O(1) //
    // Space -> O(1) //

    private static ListNode insertBeforeHead(ListNode head, int value) {
        ListNode newHead = new ListNode(value, head, null);

        head.prev = newHead;

        return newHead;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode insertBeforeTail(ListNode head, int value) {
        if (head.next == null) {
            return insertBeforeHead(head, value);
        }

        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode prevNode = tail.prev;

        ListNode newNode = new ListNode(value, tail, prevNode);

        prevNode.next = newNode;
        tail.prev = newNode;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode insertBeforeKthNode(ListNode head, int value, int k) {
        if (k == 1) {
            return insertBeforeHead(head, value);
        }

        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;

            if (count == k) {
                break;
            }
            temp = temp.next;
        }

        ListNode prevNode = temp.prev;

        ListNode newNode = new ListNode(value, temp, prevNode);

        prevNode.next = newNode;
        temp.prev = newNode;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode insertBeforeElement(ListNode head, int value, int data) {
        ListNode temp = head;

        while (temp.data != data) {
            temp = temp.next;
        }

        ListNode prevNode = temp.prev;

        ListNode newNode = new ListNode(value, temp, prevNode);

        prevNode.next = newNode;
        temp.prev = newNode;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 21, 73, 47 };

        ListNode head = convertArrayToDLL(arr);
        printDLL(head);

        ListNode newHead = insertBeforeHead(head, 2);
        printDLL(newHead);

        ListNode newTail = insertBeforeTail(head, 2);
        printDLL(newTail);

        ListNode kthElement = insertBeforeKthNode(head, 2, 3);
        printDLL(kthElement);

        ListNode newList = insertBeforeElement(head, 2, 73);
        printDLL(newList);
    }
}