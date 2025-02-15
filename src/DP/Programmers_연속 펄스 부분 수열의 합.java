import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        long curSum = 0, maxSum = Long.MIN_VALUE;
        
        // 펄스 1 적용 & 카데인 알고리즘
        for (int i = 0; i < n; i++) {
            long num = sequence[i] * ((i % 2 == 0) ? 1 : -1);
            curSum = Math.max(curSum + num, num);
            maxSum = Math.max(maxSum, curSum);
        }
        
        long answer = maxSum;
        curSum = 0;
        maxSum = Long.MIN_VALUE;
        
        // 펄스 2 적용 & 카데인 알고리즘
        for (int i = 0; i < n; i++) {
            long num = sequence[i] * ((i % 2 == 0) ? -1 : 1);
            curSum = Math.max(curSum + num, num);
            maxSum = Math.max(maxSum, curSum);
        }
        
        return Math.max(answer, maxSum);
    }
}
