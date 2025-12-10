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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake=new ListNode(0);
        fake.next=head;
        ListNode start=fake;
        ListNode sec=fake;
        for(int i=0;i<=n;i++){
            start=start.next;
        }
        while (start != null) {
            start = start.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;
        return fake.next;
    }
}