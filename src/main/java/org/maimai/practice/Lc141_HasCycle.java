package org.maimai.practice;

import org.maimai.base.ListNode;

/**
 * @Date 2022/11/1 17:26
 * @Author chenqi
 */
public class Lc141_HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            ListNode l = fast.next.next;
            ListNode l2 = slow.next;
            if (l == l2) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
