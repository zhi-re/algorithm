package org.maimai.tree;

import org.maimai.base.TreeNode;

/**
 * BM36 判断是不是平衡二叉树
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 *
 * @Date 2022/12/28 11:23
 * @Author chenqi
 */
public class BalancedSolution {


    /**
     * 第一个函数递归遍历二叉树所有节点。
     * 对于每个节点判断，调用第二个函数获取子树深度。
     * 第二个函数递归获取子树深度，只需要不断往子节点深度遍历，累加左右深度的较大值。
     * 根据深度判断该节点下的子树是否为平衡二叉树。
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        // 左子树深度减去右子树相差绝对值大于1
        return Math.abs(getDept(root.left) - getDept(root.right)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getDept(TreeNode root) {
        if (root == null) return 0;
        int left = getDept(root.left);
        int right = getDept(root.right);
        return left > right ? left + 1 : right + 1;
    }


}
