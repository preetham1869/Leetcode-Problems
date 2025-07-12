/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Check if the list is empty or has only one node, or if k is zero
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < len - k - 1; i++) {
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        curr.next = head;
        
        return newHead; 
    }
}
