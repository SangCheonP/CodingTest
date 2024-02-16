package Imple;
/*
백준 2615 오목(실버1)
https://www.acmicpc.net/problem/2615
 */

import java.util.Scanner;

import static java.lang.System.exit;

public class Baek_2615_오목 {
    static int[][] map = new int[19][19];
    //                 →  ↓  ↘  ↗
    static int[] di = {0, 1, 1, -1};
    static int[] dj = {1, 0, 1, 1};

    public static void check(int i, int j){
        // 바둑알 색
        int target = map[i][j];

        for(int k = 0; k < 4; k++){
            // 연속된 바둑알 수
            int cnt = 1;
            int ni = i + di[k];
            int nj = j + dj[k];

            while(0 <= ni && ni <= 18 && 0 <= nj && nj <= 18 && target == map[ni][nj]){
                cnt += 1;

                if(cnt == 5){
                    // 육목 체크
                    if(0 <= i - di[k] && i - di[k] <= 18 && 0 <= j - dj[k] && j - dj[k] <= 18 &&
                        target == map[i - di[k]][j - dj[k]]){
                        break;
                    }
                    if(0 <= ni + di[k] && ni + di[k] <= 18 && 0 <= nj + dj[k] && nj + dj[k] <= 18 &&
                            target == map[ni + di[k]][nj + dj[k]]){
                        break;
                    }


                    System.out.println(target);
                    System.out.println((i + 1) + " " + (j + 1));
                    exit(0);
                }

                ni += di[k];
                nj += dj[k];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(map[i][j] != 0)
                    check(i, j);
            }
        }

        System.out.println(0);
    }
}
