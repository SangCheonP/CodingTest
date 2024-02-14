package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 6987 월드컵 (골드4)
https://www.acmicpc.net/problem/6987
 */
public class Baek_6987 {
    public static boolean canMake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 0: A / 1: B / 2: C / 3: D / 4: E / 5: F
        // 승 무 패
        // 6개국의 결과 배열
        int[][] countrys = new int[6][3];
        // 현재 결과 상태
        int[][] curRes = new int[6][3];

        for (int tc = 0; tc < 1; tc++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    countrys[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int t1 = 0; t1 <= 4; t1++) {
                for (int t2 = t1 + 1; t2 <= 5; t2++) {
                    dfs(countrys, curRes, t1, t2);
                }
            }

        }
    }

    public static void dfs(int[][] countrys, int[][] curRes, int t1, int t2){
        if(t1 > 4 || t2 > 5){
            return;
        }

        // 모든 팀이 다 대결했으면
        if(t1 == 4 && t2 == 5){
            int tmp = 0;
            for (int i = 0; i < 6; i++) {
                // 만들 수 없는 결과면
                if(curRes[i][0] == countrys[i][0] && curRes[i][1] == countrys[i][1] && curRes[i][2] == countrys[i][2]){
                    tmp++;
                }else{
                    return;
                }
            }
            // 모두 일치하면
            if (tmp == 6){
                canMake = true;
                return;
            }
        }

        for (int i = 0; i < 6; i++) {
            // 만들 수 없는 결과면
            if(curRes[i][0] > countrys[i][0] || curRes[i][1] > countrys[i][1] || curRes[i][2] > countrys[i][2]){
                return;
            }
        }

        // t1이 이기면
        curRes[t1][0] += 1;
        curRes[t2][2] += 1;
        print(curRes);
        dfs(countrys, curRes, t1, t2+1);
//        curRes[t1][0] -= 1;
//        curRes[t2][2] -= 1;

        // 무승부
        curRes[t1][1] += 1;
        curRes[t2][1] += 1;
        print(curRes);
        dfs(countrys, curRes, t1, t2+1);
//        curRes[t1][1] -= 1;
//        curRes[t2][1] -= 1;

        // t1이 지면
        curRes[t1][2] += 1;
        curRes[t2][0] += 1;
        print(curRes);
        dfs(countrys, curRes, t1, t2+1);
//        curRes[t1][2] -= 1;
//        curRes[t2][0] -= 1;
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
