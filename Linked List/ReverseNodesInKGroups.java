/*
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in
 * the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 */

class ReverseNodesInKGroups {
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

    // Time -> O(k) //
    // Space -> O(1) //

    private static ListNode getKthNode(ListNode temp, int k) {
        k -= 1;

        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        
        return temp;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);

            if (kthNode == null) {
                break;
            }

            ListNode nextHead = kthNode.next;
            kthNode.next = null;

            ListNode newHeadOfKGroup = reverse(temp);

            if (temp == head) {
                head = newHeadOfKGroup;
            } else {
                prevNode.next = newHeadOfKGroup;
            }

            prevNode = temp;
            temp = nextHead;
        }

        if (prevNode != null) {
            prevNode.next = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 2;

        ListNode head = convertArrayToLL(arr);

        printLL(reverseKGroup(head, k));
    }
}