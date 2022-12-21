package org.maimai.tree;

import org.maimai.base.TreeNode;

/**
 * BM28 二叉树的最大深度
 *
 * @Date 2022/12/21 16:34
 * @Author chenqi
 */
public class MaxDepth {

    /**
     * 终止条件： 当进入叶子节点后，再进入子节点，即为空，没有深度可言，返回0.
     * 返回值： 每一级按照上述公式，返回两边子树深度的最大值加上本级的深度，即加1.
     * 本级任务： 每一级的任务就是进入左右子树，求左右子树的深度。
     * <p>
     * step 1：对于每个节点，若是不为空才能累计一次深度，若是为空，返回深度为0.
     * step 2：递归分别计算左子树与右子树的深度。
     * step 3：当前深度为两个子树深度较大值再加1。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l + 1 : r + 1;
    }

}
