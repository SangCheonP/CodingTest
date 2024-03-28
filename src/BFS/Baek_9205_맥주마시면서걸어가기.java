package BFS;

/**
 * 백준 9205 맥주 마시면서 걸어가기(골드5)
 * https://www.acmicpc.net/problem/9205
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_9205_맥주마시면서걸어가기 {
    public static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        List<Point> pointList; // n+2 개
        List<List<Integer>> graph; // (n+2)^2개
        Queue<Integer> queue; // 1개

        while (--TC >= 0){
            // 좌표 리스트
            pointList = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n+2; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                pointList.add(new Point(y, x));
            }

            // 인접 리스트 생성
            graph = new ArrayList<>();

            for (int i = 0; i < n+2; i++) {
                graph.add(new ArrayList<>());
            }

            // 인접 리스트 초기화 진행
            for (int i = 0; i < n+2; i++) {
                for (int j = i+1; j < n+2; j++) {
                    if(calcDis(pointList.get(i), pointList.get(j)) <= 1000){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            // bfs 진행
            queue = new LinkedList<>();
            // 시작점에서 연결된 모든 정점을 넣음
            // 방문 체크 배열 - n+2개
            boolean[] visited = new boolean[pointList.size()];
            visited[0] = true;
            queue.offer(0);

            boolean canMake = false;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                if(cur == pointList.size()-1){
                    canMake = true;
                    break;
                }

                for (int next : graph.get(cur)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }

            }

            System.out.println(canMake ? "happy" : "sad");
        }
    }

    public static int calcDis(Point p1, Point p2){
        return(Math.abs(p1.i - p2.i) + Math.abs(p1.j - p2.j));
    }
}
