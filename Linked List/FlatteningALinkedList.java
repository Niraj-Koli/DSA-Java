/*
 * Given a Linked List of size N, where every node represents a sub-linked-list
 * and contains two pointers:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * Each of the sub-linked-list is in sorted order.
 * Flatten the Link List such that all the nodes appear in a single level while
 * maintaining the sorted order.
 * 
 * Note: The flattened list will be printed using the bottom pointer instead of
 * the next pointer.
 * For more clarity have a look at the printList() function in the driver code.
 */

class FlatteningALinkedList {
    private static class ListNode {
        private int data;
        private ListNode next;
        ListNode child;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    private static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.child;
        }
    }

    // Time -> O(n + m) //
    // Space -> O(1) //

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);

        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.child = list1;
                temp = list1;
                list1 = list1.child;
            } else {
                temp.child = list2;
                temp = list2;
                list2 = list2.child;
            }
            temp.next = null;
        }

        if (list1 != null) {
            temp.child = list1;
        } else {
            temp.child = list2;
        }

        if (dummy.child != null) {
            dummy.child.next = null;
        }
        
        return dummy.child;
    }

    // Time -> O(n + m) //
    // Space -> O(1) //

    private static ListNode flatten(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mergeHead = flatten(head.next);
        head = merge(head, mergeHead);

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(7);
        head.next.next = new ListNode(8);
        head.next.child = new ListNode(6);
        head.next.next.child = new ListNode(10);
        head.next.next.child.next = new ListNode(12);

        printLL(flatten(head));
    }
}
