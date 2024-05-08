/*
 * Given a linked list of size N. The task is to complete the function
 * countNodesinLoop() that checks whether a given Linked List contains a loop or
 * not and if the loop is present then return the count of nodes in a loop or
 * else return 0. C is the position of the node to which the last node is
 * connected. If it is 0 then no loop.
 */

class LengthOfLoop {
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

    // Time -> O(n) //
    // Space -> O(1) //

    private static int lengthOfLoop(ListNode slow, ListNode fast) {
        int count = 1;

        slow = slow.next;

        while (slow != fast) {
            count++;
            slow = slow.next;
        }

        return count;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static int countNodesInLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return lengthOfLoop(slow, fast);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = convertArrayToLL(arr);
        printLL(head);

        head.next.next.next.next.next = head.next;

        System.out.println(countNodesInLoop(head));
    }
}