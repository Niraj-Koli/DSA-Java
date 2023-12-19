/*
 * You are given the head of a doubly Linked List and a Key. Your task is to
 * delete all occurrences of the given key and return the new DLL.
 */

public class DeleteAllOccurrencesOfAGivenKeyInADoublyLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static ListNode convertArrayToDLL(int[] arr) {
        int n = arr.length;

        ListNode head = new ListNode(arr[0]);
        ListNode prevNode = head;

        for (int i = 1; i < n; i++) {
            ListNode temp = new ListNode(arr[i], null, prevNode);
            prevNode.next = temp;
            prevNode = temp;
        }

        return head;
    }

    public static void printDLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode deleteAllOccurOfX(ListNode head, int x) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == x) {
                if (temp == head) {
                    head = temp.next;
                }

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 10, 8, 4, 2, 5, 2 };
        int key = 2;

        ListNode head = convertArrayToDLL(arr);

        printDLL(head);

        ListNode answer = deleteAllOccurOfX(head, key);

        printDLL(answer);
    }
}