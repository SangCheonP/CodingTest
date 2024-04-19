package Imple;
/**
 * 백준 14503 로봇 청소기(G5)
 * https://www.acmicpc.net/problem/14503
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14503_로봇청소기 {

    public static int N, M;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = 0;

        while(true){
            // 0: 청소x, 1: 벽, 2: 청소o
            // 현재 칸이 더러우면 청소
            if(map[r][c] == 0){
                map[r][c] = 2;
                result += 1;
            }

            // 주변 4칸이 모두 청소됐으면
            if(checkAroundClear(r, c)){
                int cd = changeDir(d);
                int nr = r + dr[cd];
                int nc = c + dc[cd];
                // 후진할 공간이 벽이면 작동 멈춤
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 1){
                    break;
                }else{
                    // 방향 유지하면서 후진 후 1번으로
                    r = nr;
                    c = nc;
                }
            }else{// 주변 4칸에 청소되지 않은 칸이 있으면
                // 반시계 방향으로 회전
                d -= 1;
                if(d == -1){
                    d = 3;
                }
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한칸 전진
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0){
                    r = nr;
                    c = nc;
                }
            }
        }
        System.out.println(result);
    }

    // 주변 4방향 모두 청소됐으면 true 반환
    public static boolean checkAroundClear(int r, int c){
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0){
                return false;
            }
        }
        return true;
    }

    public static int changeDir(int d){
        switch (d){
            case 0: // 상
                return 2;
            case 1: // 우
                return 3;
            case 2: // 하
                return 0;
            case 3: // 좌
                return 1;
        }
        return -1;
    }
}












