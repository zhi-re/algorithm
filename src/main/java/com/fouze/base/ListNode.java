package com.fouze.base;

import lombok.Data;

/**
 * @Date 2022/10/9 17:29
 * @Author chenqi
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
