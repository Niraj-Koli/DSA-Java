/*
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
 */

class SortLinkedList {
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

    private static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode dummy = new ListNode(-1);

        ListNode temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        return dummy.next;
    }

    // Time -> O(n * log(n)) //
    // Space -> O(log(n)) //

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = middleNode(head);

        ListNode rightNode = middle.next;
        middle.next = null;

        ListNode leftList = sortList(head);
        ListNode rightList = sortList(rightNode);

        return mergeTwoLists(leftList, rightList);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 5, 3, 4, 0 };

        ListNode head = convertArrayToLL(arr);
        printLL(head);

        printLL(sortList(head));
    }
}