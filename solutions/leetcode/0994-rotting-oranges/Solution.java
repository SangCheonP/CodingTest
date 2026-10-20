import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private static final int[] DI = {1, -1, 0, 0};
    private static final int[] DJ = {0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                } else if (grid[i][j] == 2) {
                    // 처음 썩은 오렌지를 모두 시작점으로 등록
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int t = 0;
        while (cnt > 0 && !queue.isEmpty()) {
            // 이번 시간대에 처리할 원소 수를 고정
            int size = queue.size();
            t++;

            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = cur[0] + DI[d];
                    int nj = cur[1] + DJ[d];

                    if (ni < 0 || ni >= grid.length
                            || nj < 0 || nj >= grid[0].length) {
                        continue;
                    }

                    if (grid[ni][nj] == 1) {
                        queue.offer(new int[]{ni, nj});
                        // 큐에 넣을 때 상태를 변경하여 중복 추가 방지
                        grid[ni][nj] = 2;
                        cnt--;

                        if (cnt == 0) {
                            return t;
                        }
                    }
                }
            }
        }

        return cnt == 0 ? t : -1;
    }
}
