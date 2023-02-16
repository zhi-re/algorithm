package com.fouze.linkedlist;

import com.fouze.base.ListNode;

/**
 * BM6 判断链表中是否有环
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 *
 * @Date 2022/12/3 21:36
 * @Author chenqi
 */
public class HasCycle {

    /**
     * 快慢指针
     * step 1：设置快慢两个指针，初始都指向链表头。
     * step 2：遍历链表，快指针每次走两步，慢指针每次走一步。
     * step 3：如果快指针到了链表末尾，说明没有环，因为它每次走两步，所以要验证连续两步是否为NULL。
     * step 4：如果链表有环，那快慢双指针会在环内循环，因为快指针每次走两步，因此快指针会在环内追到慢指针，二者相遇就代表有环。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }


}
