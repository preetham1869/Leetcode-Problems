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
     int forGCD(int a,int b){
        while(b!=0) {
            int x=b;// x is a temporary variable
            b=a%b;
            a=x;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode x=head;
        while(x!=null && x.next!=null){
            int ans = forGCD(x.val,x.next.val);
            ListNode gcd = new ListNode(ans);
            gcd.next=x.next;
            x.next=gcd;
            x=gcd.next;
        }
        return head;
    }
}