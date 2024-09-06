package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 20055 컨베이어 벨트 위의 로봇 골드5
 * https://www.acmicpc.net/problem/20055
 * 구현
 */
public class Baek_20055_컨베이어벨트위의로봇 {
    static Point[] conv;
    static int N, K, result, fin;

    static class Point{
        int A;
        boolean onBox;

        Point(int A, boolean onBox){
            this.A = A;
            this.onBox = onBox;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 내리는 위치
        // K: 내구도가 0인 칸이 K개 이상이면 종료
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1 ~ 2N까지 사용
        conv = new Point[2*N+1];
        st = new StringTokenizer(br.readLine());

        // 배열 초기화
        for(int i = 1; i <= 2*N; i++){
            conv[i] = new Point(Integer.parseInt(st.nextToken()), false);
        }

        for(int i = 1; i <= 2*N; i++){
            System.out.print(conv[i].A + " ");
        }
        System.out.println();

        RotateConv();

        for(int i = 1; i <= 2*N; i++){
            System.out.print(conv[i].A + " ");
        }
    }

    // 컨베이어 벨트 회전
    static void RotateConv(){
        Point last = new Point(conv[2*N].A, conv[2*N].onBox);

        for (int i = 2*N-1; i > 0; i--) {
            conv[i+1].A = conv[i].A;
            conv[i+1].onBox = conv[i].onBox;
        }

        conv[1] = last;
    }

    // 로봇 이동
    static void RotateRobot(){
        // 내리는 지점 바로 전에 로봇이 있고, 내리는 지점 내구도가 1이상이면
        if(conv[N-2].onBox && conv[N-1].A >= 1){
            // 내구도 1감소
            conv[N-1].A--;
        }

        for (int i = N-2; i > 0; i--) {
            if(0 > i - 1 || i + 1 > N - 1) continue;
            if(!conv[i].onBox && conv[i+1].A > 0){
                conv[i].onBox = conv[i-1].onBox;
            }
        }
    }

    // 물건 내리기
    static void downBox(int idx){
        conv[idx].onBox = false;
    }


    // 물건 올리기
    static void onBox(){

    }
}
