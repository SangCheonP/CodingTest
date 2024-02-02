package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA 5215 햄버거 다이어트 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
 */
public class SWEA_5215 {
    public static int N, L;
    public static ingredient[] arr;
    public static int max;
    static class ingredient{
        int taste;
        int kcal;

        public ingredient(int taste, int kcal){
            this.taste = taste;
            this.kcal = kcal;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            // 재료의 수, 제한 칼로리
            st = new StringTokenizer(br.readLine());
            // N: 재료의 수
            N = Integer.parseInt(st.nextToken());
            // L: 제한 칼로리
            L = Integer.parseInt(st.nextToken());

            // 재료들의 정보를 저장하는 배열
            arr = new ingredient[N];

            // 재료를 받음
            for(int g = 0; g < N; g++){
                String[] tmp = br.readLine().split(" ");
                arr[g] = new ingredient(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            }
            
//            for (int i = 0; i < arr.length; i++){
//                System.out.println("i: " + i + ", taste: " + arr[i].taste + ", kcal: " + arr[i].kcal);
//            }

            // 출력 결과
            max = 0;
            
            // 재료 번호, 맛누적, 칼로리 누적
            subset(0, 0, 0);
            System.out.println("#" + tc + " " + max);
        }
    }
    public static void subset(int idx, int tasteSum, int kcalSum){
        // 제한 칼로리 넘으면 가지치기
        if(kcalSum > L)
            return;
        // 마지막 재료까지 선택/비선택 할 시
        if(idx == N){
            //System.out.println("tasteSum: " + tasteSum + ", kcalSum: " + kcalSum);
            // 최고의 맛 선택
            max = Math.max(max, tasteSum);
            return;
        }
        
        // idx 재료 선택
        subset(idx + 1, tasteSum + arr[idx].taste, kcalSum + arr[idx].kcal);
        // idx 재료 비선택
        subset(idx + 1, tasteSum, kcalSum);
    }
}
