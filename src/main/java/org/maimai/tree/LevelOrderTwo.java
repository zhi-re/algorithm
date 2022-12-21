package org.maimai.tree;

import org.junit.Test;
import org.maimai.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * BM27 按之字形顺序打印二叉树
 *
 * @Date 2022/12/20 17:16
 * @Author chenqi
 */
public class LevelOrderTwo {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (pRoot != null)
            list.add(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!list.isEmpty()) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            ArrayList<Integer> arrayList = new ArrayList();
            for (int i = list.size(); i > 0; i--) {
                TreeNode poll = list.poll();
                if (result.size() % 2 == 0) {
                    linkedList.addLast(poll.val);
                } else {
                    linkedList.addFirst(poll.val);
                }
                if (poll.left != null) {
                    list.add(poll.left);
                }
                if (poll.right != null) {
                    list.add(poll.right);
                }
            }
            arrayList.addAll(linkedList);
            result.add(arrayList);
        }
        return result;
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
        System.out.println(Print(node));
    }
}
