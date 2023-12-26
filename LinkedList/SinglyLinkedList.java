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

public class SinglyLinkedList {
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

    public static int lengthOfLL(ListNode head) {
        ListNode temp = head;

        int length = 0;

        while (temp != null) {
            temp = temp.next;
            length++;
        }

        return length;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode front;

        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };

        ListNode head = convertArrayToLL(arr);

        printLL(head);
    }
}
