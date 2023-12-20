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

public class DeletionsInALinkedList {
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

    public static ListNode removeHead(ListNode head) {
        if (head == null) {
            return head;
        }
        head = head.next;

        return head;
    }

    public static ListNode removeTail(ListNode head) {
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

    public static ListNode removeKthElement(ListNode head, int k) {
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

    public static ListNode removeElement(ListNode head, int target) {
        if (head == null) {
            return head;
        }

        if (head.val == target) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            if (temp.val == target) {
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

        // ListNode newHead = removeHead(head);

        // printLL(newHead);

        // ListNode newTail = removeTail(newHead);

        // printLL(newTail);

        // ListNode kthElement = removeKthElement(head, 5);

        // printLL(kthElement);

        ListNode newList = removeElement(head, 7);

        printLL(newList);
    }
}
