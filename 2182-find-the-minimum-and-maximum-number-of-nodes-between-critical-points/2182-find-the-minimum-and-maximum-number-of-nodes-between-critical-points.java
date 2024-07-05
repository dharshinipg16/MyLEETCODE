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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int dis1=0;
        int dis2=0;
        int min=1000000;
        int max = -1;

        ListNode prev = head;
        ListNode cur = head.next;
        
        //starts at 2nd node
        //breaks at last node itself, anyway last node is not a critical node
        boolean flag = false;
        while (cur.next!=null) {
            if ((cur.val < prev.val && cur.val < cur.next.val) || (cur.val > prev.val && cur.val > cur.next.val)) {
                //it is a critical node, check the distances
                flag = true;
                if (dis1 < min && dis1!=0) {
                    min = dis1;
                    System.out.println("MIN UPDATE"+cur.val+" "+dis1);
                }
                if (dis2 > max && dis2!=0) {
                    max = dis2;
                    System.out.println("MAX UPDATE"+cur.val+" "+dis2);
                }
                dis1=1; //reset dis1 to 0, min dis is dis bet 2 critical nodes
                dis2+=1;//dis bet first and last cri nodes, so no need to reset
            } else if (flag == true) {
                System.out.println("NOT A CRITICAL POINT "+cur.val+" "+flag);
                dis1+=1;
                dis2+=1;
            }
            
             
            prev=cur;
            cur=cur.next;
        }
        int[] ans = new int[2];
        if (min!=1000000 && min!=0) {
            ans[0]=min;
        }else {
            ans[0]=max;
        }
        ans[1]=max;
        return ans;
        
    }
}