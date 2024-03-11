package Imple;

/*
백준 14891 톱니바퀴(골드5)
https://www.acmicpc.net/problem/14891
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_14891_톱니바퀴 {
    static int[][] gear;
    static int d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gear = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0){
            st = new StringTokenizer(br.readLine());

            int gearN = Integer.parseInt(st.nextToken()) - 1;
            int trunDir = Integer.parseInt(st.nextToken());

            // 기어가 돌아갈 방향 저장
            // 안 돌아가면 0;
            d = new int[4];

            d[gearN] = trunDir;
            checkDir(gearN);
            gearTurn();
        }

        int result = 0;
        if(gear[0][0] == 1) result += 1;
        if(gear[1][0] == 1) result += 2;
        if(gear[2][0] == 1) result += 4;
        if(gear[3][0] == 1) result += 8;

        System.out.println(result);
    }

    // 회전하는 톱니바퀴 저장
    static void checkDir(int gearN){
        // 좌측 기어
        for (int i = gearN-1; i >= 0; i--) {
            // 다른 극이면
            if(gear[i][2] != gear[i+1][6]){
                // 반대 방향으로 돌게 저장
                d[i] = -d[i+1];
            }else{
                break;
            }
        }

        // 우측 기어
        for (int i = gearN+1; i < 4; i++) {
            if(gear[i][6] != gear[i-1][2]){
                d[i] = -d[i-1];
            }else{
                break;
            }
        }
    }

    static void gearTurn(){
        int tmp = 0;

        // 4개의 기어를
        for (int i = 0; i < 4; i++) {
            // 시계 방향이면
            if(d[i] == 1){
                tmp = gear[i][7];
                for (int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j-1];
                }
                gear[i][0] = tmp;
            }
            // 반 시계 방향이면
            if(d[i] == -1){
                tmp = gear[i][0];
                for (int j = 1; j <=7 ; j++) {
                    gear[i][j-1] = gear[i][j];
                }
                gear[i][7] = tmp;
            }
        }
    }

}
