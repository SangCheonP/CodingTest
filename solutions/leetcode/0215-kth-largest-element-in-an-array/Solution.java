import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.offer(n);

            // 가장 큰 k개만 남기도록 최솟값을 제거
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 남은 k개 중 최솟값이 전체에서 k번째로 큰 값
        return pq.peek();
    }
}
