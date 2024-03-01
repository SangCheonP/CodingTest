package Comb;
/*
백준 1941 소문난 칠공주(골드3)
https://www.acmicpc.net/problem/1941
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Baek_1941_소문난칠공주 {
    static final int N = 5;
    static int result = 0;
    static int[] choice;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static char[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // BFS 방문 체크용 배열
        visited = new int[N][N];
        // 선택한 공주들의 idx 저장 배열
        choice = new int[7];

        comb(0, 0, 0);

        System.out.println(result);
    }
    
    static void comb(int idx, int yCnt, int sCnt){
        // 7명 조합
        if(yCnt + sCnt == 7){
            // 이다솜파 4명이상
            if(sCnt >= 4){
                // 모두 연결되어 있으면
                if(check()){
                    result += 1;
                }
                return;
            }else{
                return;
            }
        }

        if(idx >= N*N){
            return;
        }

        int i = idx / N;
        int j = idx % N;

        // 해당 idx 선택
        choice[yCnt + sCnt] = idx;
        // 0: 선택X / 1: 선택O / 2: BFS 방문O
        visited[i][j] = 1;

        // 해당 선택
        if(map[i][j] == 'Y'){
            comb(idx + 1, yCnt + 1, sCnt);
        }else {
            comb(idx + 1, yCnt, sCnt + 1);
        }

        // 선택X
        visited[i][j] = 0;
        comb(idx + 1, yCnt, sCnt);
    }

    static boolean check(){
        int[][] cpVisited = new int[N][N];

        // 원본 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cpVisited[i][j] = visited[i][j];
            }
        }

        // 연결된 공주의 수
        int cnt = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        // 처음 시작 값 큐에 넣기
        int si = choice[0] / N;
        int sj = choice[0] % N;

        cnt += 1;
        // BFS 방문을 2라 표시
        cpVisited[si][sj] = 2;
        queue.add(choice[0]);

        // BFS
        while (!queue.isEmpty()){
            int cur = queue.poll();

            // 4방향 동안
            for (int d = 0; d < 4; d++) {
                int ni = cur/N + di[d];
                int nj = cur%N + dj[d];

                // 범위 안 + 선택한 공주 + BFS 방문X
                if(0 <= ni && ni < N && 0 <= nj && nj < N && cpVisited[ni][nj] == 1){
                    cnt += 1;
                    cpVisited[ni][nj] = 2;
                    queue.add(ni*N + nj);
                }
            }
        }

        // 연결된 것 7명이 아니면
        if(cnt != 7){
            return false;
        }

        return true;
    }
}
