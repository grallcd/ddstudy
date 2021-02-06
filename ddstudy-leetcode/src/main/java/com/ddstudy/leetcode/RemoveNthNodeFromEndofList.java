package com.ddstudy.leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Grain Rain
 * @date 2021/2/5
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);

        ListNode listNode = solution.removeNthFromEnd(head, 1);
    }

    /**
     * 利用双指针的 “滑动窗口” 解法，并且以防特殊判断，新增一个哑节点指向链表的头节点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dump = new ListNode();
        dump.next = head;
        ListNode right = dump;
        ListNode left = dump;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        //  利用滑动窗口，p的下一个即是要删除的节点
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;

        return dump.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
