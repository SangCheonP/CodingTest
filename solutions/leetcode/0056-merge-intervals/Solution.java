import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                // 겹치지 않으면 이전 구간을 저장하고 새 구간을 시작
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                // 겹치는 구간은 더 큰 끝점까지 확장
                end = Math.max(end, intervals[i][1]);
            }
        }

        // 마지막 구간은 반복문이 끝난 뒤 저장
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }
}
