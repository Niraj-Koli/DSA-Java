public class InsertionsInADoublyLinkedList {
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

    public static ListNode insertBeforeHead(ListNode head, int value) {
        ListNode newHead = new ListNode(value, head, null);

        head.prev = newHead;

        return newHead;
    }

    public static ListNode insertBeforeTail(ListNode head, int value) {
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

    public static ListNode insertBeforeKthNode(ListNode head, int value, int k) {
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

    public static ListNode insertBeforeElement(ListNode head, int value, int data) {
        ListNode temp = head;

        while (temp.val != data) {
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

        // ListNode newHead = insertBeforeHead(head, 2);

        // printDLL(newHead);

        // ListNode newList = insertBeforeTail(head, 2);

        // printDLL(newList);

        // ListNode kthElement = insertBeforeKthNode(head, 2, 3);

        // printDLL(kthElement);

        ListNode newList = insertBeforeElement(head, 2, 73);

        printDLL(newList);
    }
}