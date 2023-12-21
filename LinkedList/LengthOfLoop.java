/*
 * Given a linked list of size N. The task is to complete the function
 * countNodesinLoop() that checks whether a given Linked List contains a loop or
 * not and if the loop is present then return the count of nodes in a loop or
 * else return 0. C is the position of the node to which the last node is
 * connected. If it is 0 then no loop.
 */
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

public class LengthOfLoop {
    public static int lengthOfLoop(ListNode slow, ListNode fast) {
        int count = 1;

        slow = slow.next;

        while (slow != fast) {
            count++;
            slow = slow.next;
        }

        return count;
    }

    public static int countNodesInLoop(ListNode head) {
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

    }
}