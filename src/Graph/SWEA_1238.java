package Graph;
/*
SWEA 1238 Contact (D4) - Graph, BFS
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
    public static boolean[][] map;
    public static boolean[] visited;
    public static Queue<Integer> queue;
    public static int len, str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10 ; tc++) {
            // len: 데이터의 길이 / str: 시작점
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            str = Integer.parseInt(st.nextToken());

            // 1~100 사용
            map = new boolean[101][101];
            visited = new boolean[101];

            // 시작과 끝 받음
            st = new StringTokenizer(br.readLine());
            for (int l = 0; l < len/2; l++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = true;
            }

            queue = new ArrayDeque<>();

            System.out.println("#" + tc + " " + bfs(str));
        }

    }


    public static int bfs(int str){
        // 방문
        queue.offer(str);
        visited[str] = true;
        
        int size = 1;
        int result = 0;

        // queue가 있는 동안
        while(!queue.isEmpty()){
            // 바로 옆의 정점들만
            while (--size >= 0){
                int cur = queue.poll();
                result = Math.max(result, cur);

                for (int i = 1; i <= 100 ; i++) {
                    // str -> i로 갈 수 있고, i를 방문하지 않았다면
                    if(map[cur][i] && !visited[i]){
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }

            // 더 진행할 수 있면(자식이 있으면)
            if(queue.size() != 0){
                size = queue.size();
                result = 0;
            // 리프 노드에 도달했으면
            }else{
                return result;
            }
        }
        return 0;
    }
}
