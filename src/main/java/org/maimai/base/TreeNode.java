package org.maimai.base;

import lombok.Data;

/**
 * @Date 2022/12/20 14:31
 * @Author chenqi
 */
public class TreeNode {
    public int val = 0;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
