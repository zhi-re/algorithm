package com.fouze.tree;

import com.fouze.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM25 二叉树的后序遍历
 *
 * @Date 2022/12/20 15:39
 * @Author chenqi
 */
public class PostorderTraversal {
    public int[] postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getPostorder(root, list);
        int[] r = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    private void getPostorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getPostorder(root.left, list);
        getPostorder(root.right, list);
        list.add(root.val);
    }
}
