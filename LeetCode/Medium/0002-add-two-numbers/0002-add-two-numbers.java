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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        boolean up = false;
        ListNode result = new ListNode();
        
        while (l1 != null || l2 != null) {
            
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
            } else if (l1 != null) {
                sum = l1.val;
            } else if (l2 != null) {
                sum = l2.val;
            }
            
            if (up) sum += 1;
            
            if (sum >= 10) {
                up = true;
                sum = sum % 10;
            }
            else up = false;
            
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(sum);
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (up) {
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(1);
        }
        
        return result.next;
    }
}