/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.


 */

package leetcode;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		System.out.println("result = " + removeNthFromEnd(new ListNode(1), 1).val);

	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode target = new ListNode(0);
        ListNode lead = new ListNode(0);
        target.next = head;
        lead.next = head;
        for (int i = 0; i < n; i++) {
            lead = lead.next;
        }
        
        while (lead.next != null) {
            lead = lead.next;
            target = target.next;
        }
        target.next = target.next.next;
        return head;
            
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
