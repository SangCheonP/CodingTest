package Comb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
SWEA 2112 보호필름
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
 */
public class SWEA_2112_보호필름 {
    // D: 두께, W: 가로, K: 합격 기준
    static int D, W, K, result;
    static boolean canMake;
    static int[] all0, all1;
    static int[][] film;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            all0 = new int[W];
            Arrays.fill(all0, 0);

            all1 = new int[W];
            Arrays.fill(all1, 1);

            // 0: A, 1: B
            film = new int[D][W];

            canMake = false;
            result = Integer.MAX_VALUE;

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i <= D; i++) {
                comb(0, i, 0);
                if(canMake){
                    System.out.println("#" + tc + " " + result);
                    break;
                }
            }

        }
    }

    static void comb(int idx, int cnt, int curCnt){
        if(curCnt == cnt && check()){
            result = Math.min(result, curCnt);
            canMake = true;
            return;
        }
        if(idx == D)
            return;

        int[] tmp = film[idx];

        // 약품 주입 안함
        comb(idx+1, cnt, curCnt);

        // 약품 주입
        film[idx] = all0;
        comb(idx+1, cnt, curCnt+1);
        film[idx] = all1;
        comb(idx+1, cnt, curCnt+1);

        film[idx] = tmp;
    }
    
    static boolean check(){
        for (int j = 0; j < W; j++) {
            int cnt = 1;
            for (int i = 0; i < D - 1; i++) {
                // 아래것과 같으면
                if(film[i][j] == film[i+1][j]){
                    cnt += 1;
                }else{
                    cnt = 1;
                }
                // 해당 라인 조건에 만족하면
                if(cnt == K){
                    break;
                }
            }
            // 만족하지 않으면
            if(cnt < K){
                return false;
            }
        }
        return true;
    }
}
