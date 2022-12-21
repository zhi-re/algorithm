package org.maimai.tree;

import org.junit.Test;
import org.maimai.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM29 二叉树中和为某一值的路径(一)
 *
 * @Date 2022/12/21 17:39
 * @Author chenqi
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        get(root, 0);
        System.out.println(list);
        return list.contains(sum);
    }

    List<Integer> list = new ArrayList<>();

    private int get(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum + root.val;
        if (root.left == null && root.right == null) {
            list.add(sum);
            return sum;
        }
        get(root.left, sum);
        get(root.right, sum);
        return sum;
    }

    @Test
    public void t() {
        TreeNode node = new TreeNode(1);
        TreeNode nodeLeft = new TreeNode(2);
//        TreeNode nodeRight = new TreeNode(3);
//        TreeNode nodeRightLeft = new TreeNode(15);
//        TreeNode nodeRightRight = new TreeNode(7);
        node.left = nodeLeft;
//        nodeLeft.left = null;
//        nodeLeft.right = null;
//        node.right = nodeRight;
//        nodeRight.left = nodeRightLeft;
//        nodeRight.right = nodeRightRight;
        System.out.println(hasPathSum(node, 0));
    }
}
