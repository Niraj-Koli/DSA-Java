/*
 * A number N is represented in Linked List such that each digit corresponds to
 * a node in linked list. You need to add 1 to it.
 */

public class Add1ToANumberRepresentedByLinkedList {
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

    public static ListNode addOneIterative(ListNode head) {
        head = reverse(head);

        ListNode temp = head;

        int carry = 1;

        while (temp != null) {
            temp.val += carry;

            if (temp.val < 10) {
                carry = 0;
                break;
            } else {
                temp.val = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        if (carry == 1) {
            ListNode newHead = new ListNode(1);

            head = reverse(head);

            newHead.next = head;

            return newHead;
        }
        head = reverse(head);
        return head;
    }

    public static int solve(ListNode temp, int carry) {
        if (temp == null) {
            return 1;
        }

        carry = solve(temp.next, carry);

        temp.val += carry;

        if (temp.val < 10) {
            return 0;
        } else {
            temp.val = 0;
            return 1;
        }
    }

    public static ListNode addOneRecursion(ListNode head) {
        int carry = 0;

        carry = solve(head, carry);

        if (carry == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 9, 9, 9 };

        ListNode head = convertArrayToLL(arr);

        ListNode answer = addOneRecursion(head);

        printLL(answer);
    }
}