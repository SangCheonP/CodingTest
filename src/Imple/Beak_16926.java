package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 배열 돌리기1 (실버1)
https://www.acmicpc.net/problem/16926
 */
public class Beak_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, M: 배열크기, R: 회전수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int k = 0; k < R; k++){
            // 현재 인덱스, 진행한 숫자 갯수, 방향
            int i = 0, j = 0, cnt = 0, d = 0;
            // 인덱스 제한
            int si = 0, ei = N, sj = 0, ej = M;
            // 임시로 담을 배열
            int[][] tmp = new int[N][M];

            while(true){
                int ni = i + di[d];
                int nj = j + dj[d];

                // 다음 인덱스가 범위 안이면 복사
                if(si <= ni && ni < ei && sj <= nj && nj < ej){
                    tmp[ni][nj] = map[i][j];
                    i = ni;
                    j = nj;
                    cnt++;
                // 범위 밖이면
                }else{
                    // 방향 바꾸고, 다시 돌아왔으면 제한 인덱스 줄임
                    d = (d+1)%4;
                    if(d == 0){
                        i++;
                        j++;
                        si++;
                        ei--;
                        sj++;
                        ej--;
                    }
                }

                // 모두 돌렸으면 종료
                if(cnt == N*M)
                    break;
            }

            // 회전시킨 배열 복사
            for(int z = 0; z < N; z++){
                for(int x = 0; x < M; x++){
                    map[z][x] = tmp[z][x];
                }
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
