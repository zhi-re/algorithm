package org.maimai.tree;

import org.junit.Test;
import org.maimai.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树的层序遍历
 *
 * @Date 2022/12/20 15:41
 * @Author chenqi
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null)
            list.add(root);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!list.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = list.size(); i > 0; i--) {
                TreeNode poll = list.poll();
                arrayList.add(poll.val);
                if (poll.left != null) {
                    list.add(poll.left);
                }
                if (poll.right != null) {
                    list.add(poll.right);
                }
            }
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
        System.out.println(levelOrder(node));
    }

}
