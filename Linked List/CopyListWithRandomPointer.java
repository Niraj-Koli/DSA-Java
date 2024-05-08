/*
 * A linked list of length n is given such that each node contains an additional
 * random pointer, which could point to any node in the list, or null.
 * 
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 * 
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 * 
 * Return the head of the copied linked list.
 * 
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [data, random_index] where:
 * 
 * data: an integer representing ListNode.data
 * random_index: the index of the node (range from 0 to n-1) that the random
 * pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */

class CopyListWithRandomPointer {
    private static class ListNode {
        private int data;
        private ListNode next;
        private ListNode random;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
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

    private static void insertCopyInBetween(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            ListNode nextElement = temp.next;
            ListNode copyNode = new ListNode(temp.data);

            copyNode.next = nextElement;
            temp.next = copyNode;
            temp = nextElement;
        }
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static void connectRandomPointers(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            ListNode copyNode = temp.next;

            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static ListNode getDeepCopyList(ListNode head) {
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        
        return dummy.next;
    }

    private static ListNode copyRandomList(ListNode head) {
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = convertArrayToLL(arr);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;

        ListNode deepCopyHead = copyRandomList(head);

        printLL(head);
        printLL(deepCopyHead);
    }
}