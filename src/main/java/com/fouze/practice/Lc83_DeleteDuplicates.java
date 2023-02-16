package com.fouze.practice;

import com.fouze.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * @Date 2022/10/17 19:24
 * @Author chenqi
 */
public class Lc83_DeleteDuplicates {














    /**
     * head = [1,1,2]
     * [1,2]
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode dump = new ListNode(-1);
        ListNode p = dump;
        while (head!=null){
            if (map.containsKey(head.val)) {
            }else {
                map.put(head.val,head.val);
                ListNode listNode = new ListNode(head.val);
                p.next = listNode;
                p = p.next;
            }
            head = head.next;
        }
        return dump.next;
    }


}
