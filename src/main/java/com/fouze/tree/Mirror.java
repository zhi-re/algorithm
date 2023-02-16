package com.fouze.tree;

import com.fouze.base.TreeNode;
import org.junit.Test;

/**
 * BM33 二叉树的镜像
 *
 * @Date 2022/12/26 16:11
 * @Author chenqi
 */
public class Mirror {

    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null)
            return null;
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }

    @Test
    public void t() {
        TreeNode node = new TreeNode(3);
        TreeNode nodeLeft = new TreeNode(9);
        TreeNode nodeRight = new TreeNode(20);
        TreeNode nodeRightLeft = new TreeNode(15);
        TreeNode nodeRightRight = new TreeNode(7);
        node.left = nodeLeft;
        nodeLeft.left = null;
        nodeLeft.right = null;
        node.right = nodeRight;
        nodeRight.left = nodeRightLeft;
        nodeRight.right = nodeRightRight;
        System.out.println(Mirror(node));
    }


}
