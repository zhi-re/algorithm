package org.maimai.tree;

import org.maimai.base.TreeNode;

/**
 * BM31 对称的二叉树
 *
 * @Date 2022/12/22 19:05
 * @Author chenqi
 */
public class TreeIsSymmetrical {

    /**
     * 1
     * 2  2
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return getTree(pRoot.left, pRoot.right);
    }

    private boolean getTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return getTree(left.left, right.right) && getTree(left.right, right.left);
    }


}
