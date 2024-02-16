package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
SWEA 1210 Ladder1 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
 */
public class SWEA_1210_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map;
        // 1: 좌 / 2: 상 / 3: 우
        int curD = 2;
        
        for (int tc = 1; tc <= 10; tc++) {
            int TC  = Integer.parseInt(br.readLine());
            int curi = 99, curj = 0;
            map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 맨 아래줄에서 2 찾음
            for (int i = 0; i < 100; i++) {
                if(map[99][i] == 2) {
                    curj = i;
                    break;
                }
            }

            // 맨위 도달할 때까지
            while (curi >= 0){
                // 현재 위로 진행중이면
                if(curD == 2){
                    while(curi >= 0){
                        // 좌에 길이 있으면
                        if(curj-1 >= 0 && map[curi][curj - 1] == 1) {
                            curD = 1;
                            curj--;
                            break;
                        // 우에 길이 있으면
                        } else if (curj+1 < 100 && map[curi][curj + 1] == 1) {
                            curD = 3;
                            curj++;
                            break;
                        }
                        // 좌우에 길이 없으면 계속 직진
                        curi--;
                    }
                // 현재 좌우로 진행중이면
                } else{
                    while(true){
                        // 위로 갈 수 있으면
                        if(map[curi-1][curj] == 1) {
                            curD = 2;
                            curi--;
                            break;
                        }
                        // 위로 못가면 가던 방향 계속 진행
                        if(curD == 1)
                            curj--;
                        else if (curD == 3) {
                            curj++;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + curj);
        }
    }
}
