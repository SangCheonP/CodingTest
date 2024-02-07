package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
SWEA 1861 정사각형 방 (D4) - DFS
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
 */
public class SWEA_1861_DFS {
    public static int[][] map;
    public static int N, tmp;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for(int i = 0; i < N; i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 최대 이동한 거리
            int step = Integer.MIN_VALUE;
            // 방 번호를 저장할 배열
            List<Integer> roomNum = new ArrayList<>();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // 현재 이동 거리
                    tmp = 1;
                    dfs(i, j);
                    // 같거나, 더 많이 이동한 방을 찾으면
                    if(tmp >= step){
                        // 더 많이 이동했으면
                        if(tmp > step){
                            // 그 전까지 있던 방은 삭제
                            roomNum.clear();
                        }

                        step = tmp;
                        roomNum.add(map[i][j]);
                        //System.out.println(roomNum);
                    }
                }
            }

            Collections.sort(roomNum);
            //System.out.println(roomNum);
            System.out.println("#" + tc + " " + roomNum.get(0) + " " + step);
        }
    }

    public static void dfs(int i, int j){
        // 4방향으로
        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == map[i][j] + 1){
                // 현재 이동 거리 1증가
                tmp += 1;
                dfs(ni, nj);
            }
        }

    }
}
