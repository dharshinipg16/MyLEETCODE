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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ListNode dummy=head;
        while (dummy != null){
            arr1.add(dummy.val);
            dummy=dummy.next;
        }
        ListNode iter = head;
        for (int i=arr1.size()-1 ; i>=0 ;i--) {
            if (arr1.get(i) != iter.val) {
                return false;
            }
            iter=iter.next;
        }
        return true;
    }
}