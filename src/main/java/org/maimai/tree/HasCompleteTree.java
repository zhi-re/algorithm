package org.maimai.tree;

import org.maimai.base.TreeNode;

import java.util.LinkedList;

/**
 * BM35 判断是不是完全二叉树
 *
 * @Date 2022/12/27 19:07
 * @Author chenqi
 */
public class HasCompleteTree {

    /**
     * 先判断空树一定是完全二叉树。
     * 初始化一个队列辅助层次遍历，将根节点加入。
     * 逐渐从队列中弹出元素访问节点，如果遇到某个节点为空，进行标记，代表到了完全二叉树的最下层，若是后续还有访问，则说明提前出现了叶子节点，不符合完全二叉树的性质。
     * 否则，继续加入左右子节点进入队列排队，等待访问。
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean b = false;
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            if (poll == null)
                b = true;
            else {
                if (b)
                    return false;
                list.add(poll.left);
                list.add(poll.right);
            }
        }
        return true;
    }


}
