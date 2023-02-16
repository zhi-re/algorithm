package com.fouze.doublePointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * BM89 合并区间
 * @Date 2023-02-15 20:07
 * @Author chenqi
 */
public class HeBingQuJian {

    /**
     * [[10,30],[20,60],[80,100],[150,180]]
     * [[10,60],[80,100],[150,180]]
     *
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        //去除特殊情况
        if (intervals.size() == 0) {
            return res;
        }
        //重载比较，按照区间首排序
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }
        });
        res.add(intervals.get(0));
        int count = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval o1 = intervals.get(i);
            Interval origin = res.get(count);
            // 当前遍历的start比上一个end还大的话
            if (o1.start > origin.end) {
                res.add(o1);
                count++;
            } else {
                res.remove(count);
                Interval s = new Interval(origin.start, o1.end);
                // 当前遍历的end 比 上一个end小
                if (o1.end < origin.end) {
                    s.end = origin.end;
                }
                res.add(s);
            }
        }
        return res;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
