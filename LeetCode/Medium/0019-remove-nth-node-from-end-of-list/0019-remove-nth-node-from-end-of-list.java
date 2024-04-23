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
        
        // 1. 전체 개수 계산
        int total = 0;
        for (ListNode node = head; node != null; node = node.next) {
            total++;
        }
        
        
        int target = total - n;
        
        // 2-1. 첫번째 원소 변경
        if (target == 0) {
            head = head.next;
            return head;
        }
        
        // 2-2. (total - n)th 원소 제거
        int cnt = 0;
        ListNode prev = null;
        for (ListNode node = head; node != null; node = node.next) {
            if (cnt++ == target) {
                prev.next = node.next;
                break;
            }
            prev = node;
        }
        
        return head;
    }
}