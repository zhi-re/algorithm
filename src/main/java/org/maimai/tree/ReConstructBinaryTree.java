package org.maimai.tree;

import org.maimai.base.TreeNode;

import java.util.Arrays;

/**
 * BM40 重建二叉树
 * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 *
 * @Date 2022/12/29 14:52
 * @Author chenqi
 */
public class ReConstructBinaryTree {
    // 前{1, 2,4,7, 3,5,6,8} 中{4,7,2, 1 ,5,3,8,6}
    //[1, 2,4,5 ,3],[4,2,5, 1 ,3]
    //[1,3,5]
    // 先根据前序遍历第一个点建立根节点。
    // 然后遍历中序遍历找到根节点在数组中的位置。
    // 再按照子树的节点数将两个遍历的序列分割成子数组，将子数组送入函数建立子树。
    // 直到子树的序列长度为0，结束递归。
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre.length == 0 || vin.length == 0) return null;
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++) {
            if (pre[0] == vin[i]) {
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(vin, 0, i));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(vin, i + 1, vin.length));
            }
        }
        return treeNode;
    }
}

