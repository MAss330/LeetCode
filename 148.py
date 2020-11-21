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
        // 排除特殊情况
        if (head == null || head.next == null){
            return head;
        }
        // 1 采用快慢指针找到中间节点 
        ListNode slower = head, faster = head.next;  //这里需要注意
        while (faster != null && faster.next != null){ 
            slower = slower.next;
            faster = faster.next.next;
        }
        ListNode temp = slower.next;
        slower.next = null;
        ListNode left = sortList(head); // duankai 
        ListNode right = sortList(temp);
        // finish 
        // merge
        // die dai merge
        ListNode dummpy = new ListNode(0);
        ListNode pre = dummpy;
        while (left != null && right != null){
            if (left.val <= right.val){
                pre.next = left;
                left = left.next;
            }else{
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left == null ? right : left;
        return dummpy.next;
    }
}
