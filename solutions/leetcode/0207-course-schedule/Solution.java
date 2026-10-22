import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int processed = 0;

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int prereq = p[1];
            int course = p[0];
            // 선수 과목에서 후속 과목으로 연결
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            // 선수 조건이 없는 과목부터 수강
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            processed++;

            for (int next : graph.get(cur)) {
                // 남은 선수 조건이 모두 해소되면 수강 가능
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 순환 관계가 있으면 모든 과목을 처리할 수 없음
        return processed == numCourses;
    }
}
