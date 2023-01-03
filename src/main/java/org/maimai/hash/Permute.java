package org.maimai.hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * BM55 没有重复项数字的全排列
 *
 * @Date 2023/1/3 18:59
 * @Author chenqi
 */
public class Permute {

    /**
     * 123
     * 132
     * 213
     * 231
     * 312
     * 321
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        get(res, list, 0);
        return res;
    }

    private void get(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int index) {
        if (index == list.size() - 1) {
            res.add(list);
        } else {
            for (int i = index; i < list.size(); i++) {
                swap(list, i, index);
                get(res, list, index + 1);
                swap(list, i, index);
            }
        }
    }

    private void swap(ArrayList<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

}
