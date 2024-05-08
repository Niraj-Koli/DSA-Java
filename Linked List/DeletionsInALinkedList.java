class DeletionsInALinkedList {
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

    // Time -> O(1) //
    // Space -> O(1) //

    private static ListNode removeHead(ListNode head) {
        if (head == null) {
            return head;
        }
        head = head.next;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode removeTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode removeKthElement(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        if (k == 1) {
            return head.next;
        }

        int count = 0;

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            count++;

            if (count == k) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }
        
        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode removeElement(ListNode head, int target) {
        if (head == null) {
            return head;
        }

        if (head.data == target) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            if (temp.data == target) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 21, 73, 47, 7 };

        ListNode head = convertArrayToLL(arr);
        printLL(head);

        ListNode newHead = removeHead(head);
        printLL(newHead);

        ListNode newTail = removeTail(newHead);
        printLL(newTail);

        ListNode kthElement = removeKthElement(head, 5);
        printLL(kthElement);

        ListNode newList = removeElement(head, 7);
        printLL(newList);
    }
}
