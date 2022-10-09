package org.maimai.practice;

import org.junit.Test;
import org.maimai.base.ListNode;

/**
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @Date 2022/10/9 17:29
 * @Author chenqi
 */
public class Lc19_RemoveLinkedListFromEnd {

    /**
     * <a href="https://maimai.org/1270.html">...</a>
     * 先找到n+1的结点:双指针，第一个指针先走n+1步，然后第一个指针和第二个指针一起走
     * 找到后让它的next = 它的next.next
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode p1 = dump;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        ListNode p2 = dump;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dump.next;
    }

}
