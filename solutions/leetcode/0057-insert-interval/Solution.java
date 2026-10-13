import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 새 구간보다 앞에 있는 구간을 저장
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int start = newInterval[0], end = newInterval[1];
        // 새 구간과 겹치는 구간을 병합
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        list.add(new int[]{start, end});

        // 뒤에 남은 구간을 저장
        while (i < n) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
