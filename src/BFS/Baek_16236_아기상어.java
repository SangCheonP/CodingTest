package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 16236 아기 상어(골드3)
https://www.acmicpc.net/problem/16236
 */
public class Baek_16236_아기상어 {
    public static int N, dis, result, sharkI, sharkJ, sharkSize, eatFishCnt, queueSize;
    public static int[][] map;
    // 먹을 수 있는 물고기를 저장할 우선순위 큐
    public static PriorityQueue<Point> pq;
    public static Queue<Point> queue;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};

    public static class Point implements Comparable<Point>{
        int i;
        int j;

        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Point o) {
            // 같은 높이라면 왼쪽 부터
            if(this.i == o.i){
                return this.j - o.j;
            }
            // 가장 높은 것부터
            return this.i - o.i;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 아기 상어면 위치 저장
                if(map[i][j] == 9) {
                    sharkI = i;
                    sharkJ = j;
                }
            }
        }

        // 결과
        result = 0;

        // 현재 아기 상어 크기
        sharkSize = 2;

        // 아기 상어가 먹은 물고기 수
        eatFishCnt = 0;

        pq = new PriorityQueue<>();
        queue = new ArrayDeque<>();
        boolean[][] inQueue = new boolean[N][N];

        // 아기 상어 위치 넣기
        queue.offer(new Point(sharkI, sharkJ));
        inQueue[sharkI][sharkJ] = true;
        queueSize = 1;
        dis = 0;

        while (!queue.isEmpty()){
            queueSize = queue.size();
            dis += 1;
            while(--queueSize >= 0){
                Point cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    // 범위 안에 있고, 아기 상어보다 작거나 같고, 큐에 넣은 적 없으면
                    if(0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] <= sharkSize && !inQueue[ni][nj]){
                        // 빈칸 or 사이즈가 같은 물고기라면(지나갈 수 있는 길이라면)
                        if(map[ni][nj] == 0 || map[ni][nj] == sharkSize){
                            // 큐에 추가
                            queue.offer(new Point(ni, nj));
                            inQueue[ni][nj] = true;

                            // 빈칸X and 아기 상어보다 작은 물고기라면
                        } else if(map[ni][nj] != 0 && map[ni][nj] < sharkSize){
                            // 저장
                            pq.offer(new Point(ni, nj));
                            inQueue[ni][nj] = true;
                        }
                    }
                }
            } // while
            // 먹을 것이 있으면
            if(!pq.isEmpty()) {
                Point eatIdx = pq.poll();
                // 먹은 물고기 위치를 아기 상어로 바꿔줌
                map[eatIdx.i][eatIdx.j] = 9;
                // 기존 위치를 빈칸으로 변경
                map[sharkI][sharkJ] = 0;
                sharkI = eatIdx.i;
                sharkJ = eatIdx.j;
                // 먹은 물고기 개수를 증가
                eatFishCnt += 1;

                // 최종 답을 업데이트하고 거리를 초기화
                int tmp = dis;
                result += dis;
                dis = 0;

                // 아기 상어가 자기 크기만큼 물고기를 먹으면
                if (eatFishCnt == sharkSize) {
                    sharkSize += 1;
                    eatFishCnt = 0;
                }

                // 기존 큐 초기화
                pq = new PriorityQueue<>();
                queue = new ArrayDeque<>();

                // 다시 아기 상어 위치 넣어줌
                queue.offer(new Point(sharkI, sharkJ));
                queueSize = 1;

                // queue체크 배열 초기화
                inQueue = new boolean[N][N];
                inQueue[sharkI][sharkJ] = true;
            } // if
        }
        System.out.println(result);
    }
}

