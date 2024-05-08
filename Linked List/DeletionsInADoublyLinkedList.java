class DeletionsInADoublyLinkedList {
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
        ListNode prev = head;

        for (int i = 1; i < n; i++) {
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

    // Time -> O(1) //
    // Space -> O(1) //

    private static ListNode removeHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode removeTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode prev = tail.prev;

        prev.next = null;
        tail.prev = null;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode removeKthNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int count = 0;

        ListNode kthNode = head;

        while (kthNode != null) {
            count++;

            if (count == k) {
                break;
            }

            kthNode = kthNode.next;
        }

        ListNode prev = kthNode.prev;
        ListNode front = kthNode.next;

        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            return removeHead(head);
        } else if (front == null) {
            return removeTail(head);
        }

        prev.next = front;
        front.prev = prev;

        kthNode.next = null;
        kthNode.prev = null;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode removeElement(ListNode head, int target) {
        ListNode temp = head;

        while (temp.data != target) {
            temp = temp.next;
        }

        ListNode prev = temp.prev;
        ListNode front = temp.next;

        if (front == null) {
            prev.next = null;
            temp.prev = null;

            return head;
        }

        prev.next = front;
        front.prev = prev;

        temp.next = temp.prev = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 21, 73, 47 };

        ListNode head = convertArrayToDLL(arr);
        printDLL(head);

        ListNode newHead = removeHead(head);
        printDLL(newHead);

        ListNode newTail = removeTail(head);
        printDLL(newTail);

        ListNode kthElement = removeKthNode(head, 3);
        printDLL(kthElement);

        ListNode newList = removeElement(head, 73);
        printDLL(newList);
    }
}
