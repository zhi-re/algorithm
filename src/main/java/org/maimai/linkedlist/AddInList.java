package org.maimai.linkedlist;

import org.junit.Test;
import org.maimai.base.ListNode;

/**
 * BM11 链表相加(二)
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 数据范围：0 \le n,m \le 10000000≤n,m≤1000000，链表任意值 0 \le val \le 90≤val≤9
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 *
 * @Date 2022/12/4 21:57
 * @Author chenqi
 */
public class AddInList {

    /**
     * step 1：任意一个链表为空，返回另一个链表就行了，因为链表为空相当于0，0加任何数为0，包括另一个加数为0的情况。
     * step 2：相继反转两个待相加的链表，反转过程可以参考反转链表。
     * step 3：设置返回链表的链表头，设置进位carry=0.
     * step 4：从头开始遍历两个链表，直到两个链表节点都为空且carry也不为1.
     * 每次取出不为空的链表节点值，为空就设置为0，将两个数字与carry相加，然后查看是否进位，将进位后的结果（对10取模）加入新的链表节点，连接在返回链表后面，并继续往后遍历。
     * step 5：返回前将结果链表再反转回来。
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        //任意一个链表为空，返回另一个
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        // 反转链表
        head1 = reverList(head1);
        head2 = reverList(head2);

        //添加表头
        ListNode res = new ListNode(-1);
        ListNode head = res;
        //进位符号
        int carry = 0;
        //只要某个链表还有或者进位还有
        while (head1 != null || head2 != null || carry != 0) {
            //链表不为空则取其值
            int v1 = head1 == null ? 0 : head1.val;
            int v2 = head2 == null ? 0 : head2.val;
            //相加
            int v3 = v1 + v2 + carry;
            //获取进位
            carry = v3 / 10;
            v3 %= 10;
            //添加元素
            ListNode listNode = new ListNode(v3);
            head.next = listNode;
            head = head.next;
            //移动下一个
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        //结果反转回来
        return reverList(res.next);
    }

    private ListNode reverList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            //断开链表，要记录后续一个
            ListNode temp = cur.next;
            //当前的next指向前一个
            cur.next = pre;
            //前一个更新为当前
            pre = cur;
            //当前更新为刚刚记录的后一个
            cur = temp;
        }
        return pre;
    }


    @Test
    public void t() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(2);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(addInList(listNode, listNode4));

    }

}