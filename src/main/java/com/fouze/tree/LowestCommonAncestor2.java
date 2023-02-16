package com.fouze.tree;

import org.junit.Test;
import com.fouze.base.TreeNode;

/**
 * BM38 在二叉树中找到两个节点的最近公共祖先
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 * @Date 2022/12/28 16:12
 * @Author chenqi
 */
public class LowestCommonAncestor2 {


    /**
     * 如果o1和o2中的任一个和root匹配，那么root就是最近公共祖先。
     * 如果都不匹配，则分别递归左、右子树。
     * 如果有一个节点出现在左子树，并且另一个节点出现在右子树，则root就是最近公共祖先.
     * 如果两个节点都出现在左子树，则说明最低公共祖先在左子树中，否则在右子树。
     * 继续递归左、右子树，直到遇到step1或者step3的情况。
     * 1
     * 2     3
     * 4     5
     *
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // 该子树没找到，返回-1
        if (root == null) return -1;
        // 该节点是其中某一个节点
        if (root.val == o1 || root.val == o2) return root.val;
        // 左子树寻找公共祖先
        int left = lowestCommonAncestor(root.left, o1, o2);
        // 右子树寻找公共祖先
        int right = lowestCommonAncestor(root.right, o1, o2);
        // 左子树为没找到，则在右子树中
        if (left == -1) return right;
        // 右子树没找到，则在左子树中
        if (right == -1) return left;
        // 否则是当前节点
        return root.val;
    }

    @Test
    public void t() {
        TreeNode node = new TreeNode(1);
        TreeNode nodeLeft = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(3);
        TreeNode nodeRightLeft = new TreeNode(4);
        TreeNode nodeRightRight = new TreeNode(5);
        node.left = nodeLeft;
        nodeLeft.left = null;
        nodeLeft.right = null;
        node.right = nodeRight;
        nodeRight.left = nodeRightLeft;
        nodeRight.right = nodeRightRight;
        System.out.println(lowestCommonAncestor(node, 4, 5));
    }

}
