/**
 * Description: Remove the nth node from the end of the list
 * Comment: Forgot if rabbit.next is null. Forgot if turtoise is null.
 *
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
        ListNode markHead = head;
        ListNode rabbit = head;
        ListNode turtoise = null;
        int step = 0;
        
        if(rabbit.next == null) {
            return null;
        }
        
        while (rabbit.next != null) {
            rabbit = rabbit.next;
            step++;
            if (step == n) {
               turtoise = markHead; 
            }
            if (step > n) {
                turtoise = turtoise.next;
            }
        }
        if (turtoise == null) {
            return markHead.next;
        }
        ListNode toRemove = turtoise.next;
        ListNode secondHalf = null;
        if (toRemove.next != null) {
            secondHalf = toRemove.next;
        }
        turtoise.next = secondHalf;
        return markHead;
    }
}
