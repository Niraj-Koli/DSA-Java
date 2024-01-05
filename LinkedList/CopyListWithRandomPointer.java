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
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random
 * pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static void insertCopyInBetween(Node head) {
        Node temp = head;

        while (temp != null) {
            Node nextElement = temp.next;
            Node copyNode = new Node(temp.val);

            copyNode.next = nextElement;
            temp.next = copyNode;
            temp = nextElement;
        }
    }

    public static void connectRandomPointers(Node head) {
        Node temp = head;

        while (temp != null) {
            Node copyNode = temp.next;

            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

    public static Node getDeepCopyList(Node head) {
        Node temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static Node copyRandomList(Node head) {
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }
}


// public class Solution {

//     HashMap<Node, Node> visited = new HashMap<Node, Node>();

//     public Node getClonedNode(Node node) {

//         if (node != null) {

//             if (this.visited.containsKey(node)) {

//                 return this.visited.get(node);
//             } else {

//                 this.visited.put(node, new Node(node.val, null, null));
//                 return this.visited.get(node);
//             }
//         }
//         return null;
//     }

//     public Node copyRandomList(Node head) {

//         if (head == null) {
//             return null;
//         }

//         Node oldNode = head;
//         Node newNode = new Node(oldNode.val);

//         this.visited.put(oldNode, newNode);

//         while (oldNode != null) {
//             newNode.random = getClonedNode(oldNode.random);
//             newNode.next = getClonedNode(oldNode.next);

//             oldNode = oldNode.next;
//             newNode = newNode.next;
//         }
//         return this.visited.get(head);
//     }
// }
