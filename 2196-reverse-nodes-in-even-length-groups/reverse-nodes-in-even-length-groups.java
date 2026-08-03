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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null) return null;

        ListNode current = head;
        ListNode previousGroupTail = null;
        int expectedSize = 1;

        while(current != null)
        {
            ListNode lastNode = current;
            int actualSize = 1;

            while(actualSize < expectedSize && lastNode.next != null)
            {
                lastNode = lastNode.next;
                actualSize++;
            }
            ListNode nextNode = lastNode.next;

            if(actualSize % 2 == 0)
            {
                lastNode.next = null;
                ListNode newHead = reverse(current);

                if(previousGroupTail != null) previousGroupTail.next = newHead;
                else head = newHead;

                previousGroupTail = current;
                current.next = nextNode;
            }
            else previousGroupTail = lastNode;
            current = nextNode;
            expectedSize++;
        }
        return head;
    }


    public ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode previous = null;

        while(current != null)
        {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}