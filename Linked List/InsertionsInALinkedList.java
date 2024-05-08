class InsertionsInALinkedList {
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
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

    private static ListNode insertAtHead(ListNode head, int data) {
        ListNode temp = new ListNode(data, head);
        return temp;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode insertAtTail(ListNode head, int data) {
        if (head == null) {
            return new ListNode(data, null);
        }

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        ListNode newNode = new ListNode(data, null);
        temp.next = newNode;

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode insertAtKthPosition(ListNode head, int data, int k) {
        if (head == null) {
            if (k == 1) {
                return new ListNode(data, null);
            } else {
                return head;
            }
        }

        if (k == 1) {
            return new ListNode(data, head);
        }

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;

            if (count == k - 1) {
                ListNode newNode = new ListNode(data);

                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode insertBeforElement(ListNode head, int data, int element) {
        if (head == null) {
            return null;
        }

        if (head.data == element) {
            return new ListNode(data, head);
        }

        ListNode temp = head;

        while (temp.next != null) {
            if (temp.next.data == element) {
                ListNode newNode = new ListNode(data);

                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 21, 73, 47 };

        ListNode head = convertArrayToLL(arr);
        printLL(head);

        int data = 2;
        ListNode newHead = insertAtHead(head, data);
        printLL(newHead);

        ListNode newTail = insertAtTail(head, data);
        printLL(newTail);

        ListNode newList = insertAtKthPosition(head, data, 4);
        printLL(newList);

        ListNode newElementList = insertBeforElement(head, data, 21);
        printLL(newElementList);
    }
}
