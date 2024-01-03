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

class Node {
    int val;
    Node next;
    Node child;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.child = null;
    }

    public Node(int val, Node next, Node child) {
        this.val = val;
        this.next = next;
        this.child = child;
    }
}

public class FlatteningALinkedList {
    public static void printLL(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.child;
        }
    }

    public static Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);

        Node temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
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

    public static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergeHead = flatten(head.next);
        head = merge(head, mergeHead);

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(7);
        head.next.next = new Node(8);
        head.next.child = new Node(6);
        head.next.next.child = new Node(10);
        head.next.next.child.next = new Node(12);

        Node answer = flatten(head);

        printLL(answer);
    }
}
