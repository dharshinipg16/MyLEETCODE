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
    public ListNode middleNode(ListNode head) {
        int n=1;
        ListNode cur=head;
        if (head==null) {
            n=0;
            return null;
        }else {
            while (cur != null) {
                n++;
                cur=cur.next;
            }
        }
        System.out.print(n);
        if (n%2!=0) {
            n=n/2 + 1;
        }else {
            n=n/2;
        }
        int iter=1;
        cur=head;
        while (cur != null) {
            if (iter==n) {
                return cur;
            }else {
                iter++;
                cur=cur.next;
            }
        }
        return head;
    }
}