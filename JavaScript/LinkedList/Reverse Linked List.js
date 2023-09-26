/* Given the head of a singly linked list, reverse the list, and return the reversed list. */

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

function reverseList(head) {
    let prev = null;
    let curr = head;
    let next = null;

    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}

console.log(reverseList(head));

// LeetCode //

// var reverseList = function (head) {
//     let prev = null;
//     let curr = head;
//     while (curr !== null) {
//         const nextNode = curr.next;
//         curr.next = prev;
//         prev = curr;
//         curr = nextNode;
//     }
//     return prev;
// };
