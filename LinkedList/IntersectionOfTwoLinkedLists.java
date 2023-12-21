/*
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 * 
 * For example, the following two linked lists begin to intersect at node c1:
 * 
 * 
 * The test cases are generated such that there are no cycles anywhere in the
 * entire linked structure.
 * 
 * Note that the linked lists must retain their original structure after the
 * function returns.
 * 
 * Custom Judge:
 * 
 * The inputs to the judge are given as follows (your program is not given these
 * inputs):
 * 
 * intersectVal - The value of the node where the intersection occurs. This is 0
 * if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head)
 * to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head)
 * to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and
 * pass the two heads, headA and headB to your program. If you correctly return
 * the intersected node, then your solution will be accepted.
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

public class IntersectionOfTwoLinkedLists {
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }

        return tempA;
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 1, 8, 4, 5 };
        int[] arr2 = { 5, 6, 1, 8, 4, 5 };

        ListNode headA = convertArrayToLL(arr1);
        ListNode headB = convertArrayToLL(arr2);

        ListNode answer = getIntersectionNode(headA, headB);

        printLL(answer);
    }
}

// public class Solution {
// public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
// ListNode tempA = headA;
// ListNode tempB = headB;
// int lnA = 0;
// while (tempA != null) {
// lnA++;
// tempA = tempA.next;
// }
// int lnB = 0;
// while (tempB != null) {
// lnB++;
// tempB = tempB.next;
// }
// tempA = headA;
// tempB = headB;
// if (lnA > lnB) {
// int step = lnA - lnB;
// for (int i = 1; i <= step; i++) {
// tempA = tempA.next;
// }
// } else {
// int step = lnB - lnA;
// for (int i = 1; i <= step; i++) {
// tempB = tempB.next;
// }
// }
// while (tempA != tempB) {
// tempA = tempA.next;
// tempB = tempB.next;
// }
// return tempA;

// }
// }