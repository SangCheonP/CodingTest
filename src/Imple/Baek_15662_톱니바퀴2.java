package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Baek_15662_톱니바퀴2 {
    public static int T;
    public static int[][] gearStatus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 톱니바퀴 개수
        T = Integer.parseInt(br.readLine());

        // 톱니바퀴 상태 저장 배열
        gearStatus = new int[T][8];

        for (int i = 0; i < T; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gearStatus[i][j] = tmp[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearN = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());
            // 기어들이 돌아갈 방향 배열 얻음
            int[] trunType = trunGear(gearN, type);

            // 기어돌림
            turn(trunType);
        }
        for (int t = 0; t < T; t++) {
            if(gearStatus[t][0] == 1){
                result += 1;
            }
        }
        System.out.println(result);
    }

    // 기어 회전 방향 배열을 구함
    public static int[] trunGear(int gearN, int type){
        int[] result = new int[T];
        gearN -= 1;

        result[gearN] = type;

        // 해당 기어 기준 왼쪽
        for (int i = gearN - 1; i >= 0; i--) {
            // 전 톱니바퀴가 안 돌아갔으면
            if(result[i + 1] == 0 || gearStatus[i+1][6] == gearStatus[i][2]){
                result[i] = 0;
                continue;
            }
            // 전 톱니바퀴가 돌아갔으면
            result[i] = -(result[i+1]);
        }

        // 해당 기어 기준 오른쪽
        for (int i = gearN + 1; i < T; i++) {
            // 전 톱니바퀴가 안 돌아갔으면
            if (result[i - 1] == 0 || gearStatus[i-1][2] == gearStatus[i][6]) {
                result[i] = 0;
                continue;
            }
            // 전 톱니바퀴가 돌아갔으면
            result[i] = -(result[i - 1]);
        }

        return result;
    }

    // 회전 방향을 받아 그에 맞게 배열을 돌림
    public static void turn(int[] trunType){
        for (int t = 0; t < T; t++) {
            // 시계 방향
            if(trunType[t] == 1){
                int tmp = gearStatus[t][7];
                for (int j = 7; j >=1 ; j--) {
                    gearStatus[t][j] = gearStatus[t][j-1];
                }
                gearStatus[t][0] = tmp;
            // 반시계 방향
            } else if (trunType[t] == -1) {
                int tmp = gearStatus[t][0];
                for (int j = 0; j <= 6 ; j++) {
                    gearStatus[t][j] = gearStatus[t][j+1];
                }
                gearStatus[t][7] = tmp;
            }
        }
    }
}
