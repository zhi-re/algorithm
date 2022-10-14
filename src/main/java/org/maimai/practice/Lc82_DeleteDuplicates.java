package org.maimai.practice;

import org.maimai.base.ListNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * @Date 2022/10/14 19:31
 * @Author chenqi
 */
public class Lc82_DeleteDuplicates {















    // head = [1,2,3,3,4,4,5]
    // [1,2,5]
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(-1);
        ListNode p = dump;
       Map<Integer,Integer> map = new LinkedHashMap<>();
        while (head!=null){
            if (map.containsKey(head.val)){
                Integer n = map.get(head.val);
                map.put(head.val,n+1);
            }else {
                map.put(head.val,1);
            }
            head = head.next;
        }
        for (Integer key : map.keySet()) {
            if (map.get(key)>1){
                continue;
            }
            ListNode listNode = new ListNode(key);
            p.next = listNode;
            p = p.next;
        }

        return dump.next;


    }




}
