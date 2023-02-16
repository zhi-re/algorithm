package com.fouze.tree;

import com.fouze.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * BM41 输出二叉树的右视图
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 *
 * @Date 2022/12/29 15:54
 * @Author chenqi
 */
public class SolveRight {
    public int[] solve(int[] xianxu, int[] zhongxu) {
        TreeNode treeNode = get(xianxu, zhongxu);
        List<Integer> listResult = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = cxbl(treeNode);
        for (ArrayList<Integer> arrayList : list) {
            listResult.add(arrayList.get(arrayList.size() - 1));
        }
        int result[] = listResult.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    private ArrayList<ArrayList<Integer>> cxbl(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!list.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                TreeNode poll = list.poll();
                arrayList.add(poll.val);
                if (poll.left != null) list.add(poll.left);
                if (poll.right != null) list.add(poll.right);
            }
            result.add(arrayList);
        }
        return result;

    }

    /**
     * 构造新树
     * 前{1, 2,4,7, 3,5,6,8} 中{4,7,2, 1 ,5,3,8,6}
     *
     * @param xianxu
     * @param zhongxu
     * @return
     */
    private TreeNode get(int[] xianxu, int[] zhongxu) {
        if (xianxu.length == 0 || zhongxu.length == 0) return null;
        TreeNode treeNode = new TreeNode(xianxu[0]);
        for (int i = 0; i < zhongxu.length; i++) {
            if (zhongxu[i] == xianxu[0]) {
                treeNode.left = get(Arrays.copyOfRange(xianxu, 1, i + 1),
                        Arrays.copyOfRange(zhongxu, 0, i));
                treeNode.right = get(Arrays.copyOfRange(xianxu, i + 1, xianxu.length),
                        Arrays.copyOfRange(zhongxu, i + 1, zhongxu.length));
            }
        }
        return treeNode;
    }
}
