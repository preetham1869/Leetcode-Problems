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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        int carry = 0;
        ListNode curr = head;
        while (curr != null) {
            int sum = curr.val * 2 + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                break;
            }
            curr = curr.next;
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
