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
        //
        ListNode dummpy = new ListNode(0);
        ListNode currentNode = dummpy;
        int tempValue = 0;
        while (l1 != null  && l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + tempValue;
            tempValue = sum / 10; //  进位
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l3 = l1 == null ? l2 : l1;
        while (l3 != null){
            int sum = l3.val + tempValue;
            tempValue = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            l3 = l3.next;
        }
        currentNode.next = tempValue != 0 ? new ListNode(tempValue) : null;
        return dummpy.next;

    }
}
