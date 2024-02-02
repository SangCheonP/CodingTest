package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
SWEA 6808 규영이와 인영이의 카드 게임 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
 */
public class SWEA_6808 {
    // 원본 배열
    public static int[] gyu;
    public static int[] in;

    // 순열 배열
    public static int[] inPerm = new int[9];
    public static int inIdx;

    // 원본 배열 체크
    public static boolean[] check;

    // 순열 배열 체크
    public static boolean[] checkPerm = new boolean[9];
    
    // 결과
    public static int win;
    public static int lose;

    public static int c = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            // idx 1 ~ 18 사용
            check = new boolean[19];

            gyu = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            in = new int[9];
            inIdx = 0;

            // 규영이가 뽑은 카드를 체크
            for(int i = 0; i < gyu.length; i++){
                check[gyu[i]] = true;
            }

            // 규영이가 뽑지 않은 카드를 인영이 카드배열에 저장
            for(int i = 1; i < check.length; i++){
                if(!check[i]){
                    in[inIdx++] = i;
                }
            }

            // 결과 저정 변수
            win = 0;
            lose = 0;

            // in으로 9! 조합을 만듦
            // 조합이 만들어지면 9번 비교
            // 값이 큰 쪽에 승리를 줌(무승부 있음)
            perm(0);

            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    public static void perm(int idx){
        // 9개 뽑으면
        if(idx == 9){
            // 점수 저장 변수
            int gyuSum = 0;
            int inSum = 0;
            
            // 9장의 카드를 비교해서 이긴 쪽에 점수를 줌
            for(int i = 0; i < 9; i++){
                if(gyu[i] > inPerm[i])
                    gyuSum += gyu[i] + inPerm[i];
                else if(gyu[i] < inPerm[i]){
                    inSum += gyu[i] + inPerm[i];
                }
            }

            if(gyuSum > inSum){
                win += 1;
            } else if (gyuSum < inSum) {
                lose += 1;
            }
            
            return;
        }
        
        // 9장의 카드를 뽑는 순열을 만듦
        for(int i = 0; i < in.length; i++){
            if(checkPerm[i]) continue;
            inPerm[idx] = in[i];
            checkPerm[i] = true;
            perm(idx + 1);
            checkPerm[i] = false;
        }
    }
}

