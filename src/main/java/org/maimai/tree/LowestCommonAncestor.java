package org.maimai.tree;

import org.maimai.base.TreeNode;

/**
 * BM37 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
 * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 3.所有节点的值都是唯一的。
 * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * @Date 2022/12/28 16:12
 * @Author chenqi
 */
public class LowestCommonAncestor {

    /**
     * 根据二叉搜索树的性质，从根节点开始查找目标节点，当前节点比目标小则进入右子树，当前节点比目标大则进入左子树，直到找到目标节点。这个过程成用数组记录遇到的元素。
     * 分别在搜索二叉树中找到p和q两个点，并记录各自的路径为数组。
     * 同时遍历两个数组，比较元素值，最后一个相等的元素就是最近的公共祖先。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // 调整p，q使得p<=q
        if (p > q) {
            int t = p;
            p = q;
            q = t;
        }
        int val = root.val;
        // 递归边界，如果当前root.val大于等于p且root.val小于等于q，就是答案
        if (p <= val && val <= q)
            return val;
        // 如果root.val小于q证明root.val的值太小，遍历右子树。如果root.val的值大于q证明值太大遍历左子树
        if (val > q) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

}
