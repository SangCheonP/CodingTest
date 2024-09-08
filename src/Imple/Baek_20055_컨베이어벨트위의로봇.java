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
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1 ~ 2N까지 사용
        conv = new Point[2*N+1];
        st = new StringTokenizer(br.readLine());

        // 배열 초기화
        for(int i = 1; i <= 2*N; i++){
            conv[i] = new Point(Integer.parseInt(st.nextToken()), false);
        }

        fin = 0;
        result = 0;

        while(true){
            // 단계 증가
            result += 1;
            
            // 1. 로봇과 함께 벨트 회전
            RotateConv();

            // 1-2. 내리는 지점에 로봇이 있으면 내림
            if(conv[N].onBox){
                conv[N].onBox = false;
            }

            // 2. 로봇 회전
            RotateRobot();

            // 2-2. 내리는 지점에 로봇이 있으면 내림
            if(conv[N].onBox){
                conv[N].onBox = false;
            }

            // 3. 로봇 올리기
            if(conv[1].A >= 1 && !conv[1].onBox){  // 내구도가 1 이상이고, 로봇이 없을 때
                conv[1].onBox = true;   // 로봇을 올림
                conv[1].A -= 1;         // 내구도 감소
                if(conv[1].A == 0){
                    fin += 1;           // 내구도 0이 된 칸의 개수 증가
                }
            }

            // 종료 조건 확인: 내구도가 0인 칸이 K개 이상인 경우
            if(fin >= K){
                System.out.println(result);
                break;
            }
        }
    }

    // 컨베이어 벨트 회전
    static void RotateConv(){
        Point last = conv[2*N]; // 마지막 칸의 정보를 저장

        for (int i = 2 * N - 1; i >= 1; i--) {
            conv[i+1] = conv[i]; // 객체 자체 복사
        }

        conv[1] = last; // 마지막 칸을 첫 번째 칸으로 이동
    }

    // 로봇 이동
    static void RotateRobot(){
        /**
         * N-1 -> N
         * N-2 -> N-1
         * ....
         * 1 -> 2
         */

        for(int i = N - 1; i >= 1; i--){
            // 앞에 로봇이 없고, 현재 로봇이 있고, 앞 칸이 내구도가 1 이상일 때 이동
            if(!conv[i + 1].onBox && conv[i].onBox && conv[i + 1].A >= 1) {
                conv[i + 1].onBox = true;  // 로봇을 한 칸 앞으로 이동
                conv[i].onBox = false;     // 현재 위치의 로봇을 없앰
                conv[i + 1].A -= 1;        // 앞 칸의 내구도 감소

                if(conv[i + 1].A == 0){
                    fin += 1;             // 내구도 0이 된 칸의 개수 증가
                }
            }
        }
    }
}
