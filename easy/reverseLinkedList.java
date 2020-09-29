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
    public ListNode reverseList(ListNode head) {
        //keep last = first
        //iterate through linked list
        //swap current's next is first and make current first
        
        ListNode first = null;
        ListNode current = head;
        
        while(current != null) {
            ListNode next = current.next;
            current.next = first;
            first = current;
            current = next;
        }
        return first;
    }
}
