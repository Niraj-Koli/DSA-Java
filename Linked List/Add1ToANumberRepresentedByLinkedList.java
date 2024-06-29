/*
 * A number N is represented in Linked List such that each digit corresponds to
 * a node in linked list. You need to add 1 to it.
 */

class Add1ToANumberRepresentedByLinkedList {
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

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = null;

        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode addOneIterative(ListNode head) {
        head = reverse(head);

        ListNode temp = head;

        int carry = 1;

        while (temp != null) {
            temp.data += carry;

            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
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

    private static int solve(ListNode temp, int carry) {
        if (temp == null) {
            return 1;
        }

        carry = solve(temp.next, carry);

        temp.data += carry;

        if (temp.data < 10) {
            return 0;
        } else {
            temp.data = 0;

            return 1;
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static ListNode addOneRecursion(ListNode head) {
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
        ListNode newHead = convertArrayToLL(arr);

        printLL(addOneRecursion(head));
        printLL(addOneIterative(newHead));
    }
}