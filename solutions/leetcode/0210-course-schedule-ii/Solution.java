import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> info = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            info.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            info.get(p[1]).add(p[0]);
            degree[p[0]] += 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            temp.add(cur);
            for (int next : info.get(cur)) {
                if (--degree[next] == 0) queue.offer(next);
            }
        }
        if (temp.size() != numCourses) return new int[0];

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = temp.get(i);
        }
        return order;
    }
}
