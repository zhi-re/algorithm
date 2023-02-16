package com.fouze.tree;

import com.fouze.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM24 二叉树的中序遍历
 * 输入：
 * {1,2,#,#,3}
 * 复制
 * 返回值：
 * [2,3,1]
 *
 * @Date 2022/12/20 15:26
 * @Author chenqi
 */
public class InorderTraversal {


    public int[] inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getInorder(root, list);
        int[] r = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    private void getInorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getInorder(root.left, list);
        list.add(root.val);
        getInorder(root.right, list);
    }

}
