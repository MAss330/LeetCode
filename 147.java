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
    public ListNode sortList(ListNode head) {
        // 插入排序
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode pre = head, currentNode = head.next;
        while (currentNode != null){
            if( pre.val < currentNode.val){
                pre = pre.next;
                currentNode =currentNode.next;
            }else{
                // 从头开始遍历
                ListNode temp = dummpy;
                while (temp.next.val < currentNode.val){
                    temp = temp.next;
                }
                pre.next = currentNode.next; // duankai 
                ListNode node = temp.next;
                temp.next = currentNode;
                currentNode.next = node;
                currentNode = pre.next;
            }
        }
        return dummpy.next;
        
    }
}
