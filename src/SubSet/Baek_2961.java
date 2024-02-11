package SubSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2961 도영이가 만든 맛있는 음식 (실버2)
https://www.acmicpc.net/problem/2961
 */
public class Baek_2961 {
    public static class food{
        int S;
        int B;

        public food(int S, int B){
            this.S = S;
            this.B = B;
        }
    }

    public static int result;
    public static food[] foods;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;

        foods = new food[TC];

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            foods[tc] = new food(S, B);
        }

        SubSet(0, 0, 1, 0);

        System.out.println(result);

    }

    public static void SubSet(int idx, int cnt, int sSum, int bSum){
        // 재료 끝까지 다 보면
        if(idx == foods.length){
            // 재료를 최소 한 개 사용
            if(cnt != 0){
                // 현재 선택한 재료의 절대값이 더 작으면
                if(result > Math.abs(sSum - bSum)) {
                    result = Math.abs(sSum - bSum);
                }
            }
            return;
        }

        // 해당 idx 재료를 선택
        SubSet(idx + 1, cnt + 1, sSum * foods[idx].S, bSum + foods[idx].B);

        // 해당 idx 재료 선택X
        SubSet(idx + 1, cnt, sSum, bSum);
    }
}
