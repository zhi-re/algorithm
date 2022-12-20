package org.maimai.tree;

import org.maimai.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM23 二叉树的前序遍历
 * 输入：
 * {1,#,2,3}
 * 返回值：
 * [1,2,3]
 *
 * @Date 2022/12/20 14:30
 * @Author chenqi
 */
public class PreorderTraversal {

    List<Integer> list = new ArrayList<>();

    public int[] preorderTraversal(TreeNode root) {
        getPre(root);
//        getPre2(root, new ArrayList<>());
        Integer[] integers = list.toArray(new Integer[0]);
        int[] r = new int[list.size()];
        for (int i = 0; i < integers.length; i++) {
            r[i] = integers[i];
        }
        return r;
    }


    private void getPre(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getPre(root.left);
        getPre(root.right);
    }


    private void getPre2(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getPre2(root.left, list);
        getPre2(root.right, list);
    }

}
