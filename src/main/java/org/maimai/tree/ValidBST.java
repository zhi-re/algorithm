package org.maimai.tree;

import org.junit.Test;
import org.maimai.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM34 判断是不是二叉搜索树
 * 二叉搜索树满足每个节点的左子树上的所有节点均小于当前节点且右子树上的所有节点均大于当前节点。
 * 二叉搜索树的特性是中序遍历是递增序
 *
 * @Date 2022/12/26 17:19
 * @Author chenqi
 */
public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> middle = getMiddle(root, list);
        System.out.println(middle);
        for (int i = 0; i < middle.size(); i++) {
            for (int j = i; j < middle.size(); j++) {
                System.out.println(middle.get(i));
                System.out.println(middle.get(j));
                if (middle.get(j) < middle.get(i)) {
                    System.out.println("----");
                    return false;
                }
                System.out.println();
            }
        }
        return true;
    }

    private List<Integer> getMiddle(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        getMiddle(root.left, list);
        int val = root.val;
        list.add(val);
        getMiddle(root.right, list);
        return list;
    }

    /**
     * 3
     * 2   5
     * 1     4
     */
    @Test
    public void t() {
        TreeNode node = new TreeNode(3);
        TreeNode nodeLeft = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(5);
//        TreeNode nodeRightLeft = new TreeNode(1);
//        TreeNode nodeRightRight = new TreeNode(4);
        node.left = nodeLeft;
        nodeLeft.left = null;
        nodeLeft.right = null;
        node.right = nodeRight;
//        nodeRight.left = nodeRightLeft;
//        nodeRight.right = nodeRightRight;
        System.out.println(isValidBST(node));
    }
}
