class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class InsertionsInALinkedList {
    public static ListNode convertArrayToLL(int[] arr) {
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

    public static void printLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode insertAtHead(ListNode head, int val) {
        ListNode temp = new ListNode(val, head);
        return temp;
    }

    public static ListNode insertAtTail(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val, null);
        }

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        ListNode newNode = new ListNode(val, null);
        temp.next = newNode;

        return head;
    }

    public static ListNode insertAtKthPosition(ListNode head, int val, int k) {
        if (head == null) {
            if (k == 1) {
                return new ListNode(val, null);
            } else {
                return head;
            }
        }

        if (k == 1) {
            return new ListNode(val, head);
        }

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;

            if (count == k - 1) {
                ListNode newNode = new ListNode(val);

                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }

    public static ListNode insertBeforElement(ListNode head, int val, int element) {
        if (head == null) {
            return null;
        }

        if (head.val == element) {
            return new ListNode(val, head);
        }

        ListNode temp = head;

        while (temp.next != null) {
            if (temp.next.val == element) {
                ListNode newNode = new ListNode(val);

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
        int val = 2;

        printLL(head);

        // ListNode newHead = insertAtHead(head, val);

        // printLL(newHead);

        // ListNode newTail = insertAtTail(head, val);

        // printLL(newTail);

        // ListNode newList = insertAtKthPosition(head, val, 4);

        // printLL(newList);

        ListNode newElementList = insertBeforElement(head, val, 21);

        printLL(newElementList);
    }
}
