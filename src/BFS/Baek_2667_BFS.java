package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 2667 단지번호붙이기 (실버1) - BFS 버전
https://www.acmicpc.net/problem/2667
 */
public class Baek_2667_BFS {
    public static class idx{
        int i;
        int j;

        public idx(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    // 결과, 각 단지의 수를 잠시 저장할 변수
    public static int result, tmp, N;
    public static List<Integer> arr;
    public static int[][] map;

    public static Queue<idx> queue;
    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = 0; // 단지의 가지 수
        arr = new ArrayList<>(); // 각 단지의 개수를 저장할 리스트
        queue = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 방문하지 않은 단지가 있으면
                if(map[i][j] == 1){
                    ++result;
                    tmp = 0;
                    queue.offer(new idx(i, j));
                    // 방문했다 표시
                    map[i][j] = 2;

                    while(!queue.isEmpty()){
                        idx curIdx = queue.poll();
                        // 해당 단지의 개수 증가
                        ++tmp;

                        // 4방향 검사
                        for(int d = 0; d < 4; d++){
                            int ni = curIdx.i + di[d];
                            int nj = curIdx.j + dj[d];

                            if(0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == 1){
                                // 넣으면서 방문했다 표시하여 뒤에서 메모리 초과 안 뜨게 처리
                                map[ni][nj] = 2;
                                queue.offer(new idx(ni, nj));
                            }
                        }
                    }
                    arr.add(tmp);
                }
            }
        }

        System.out.println(result);
        Collections.sort(arr);
        for(int n : arr)
            System.out.println(n);
    }
}
