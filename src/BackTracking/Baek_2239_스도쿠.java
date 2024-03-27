package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_2239_스도쿠 {
    public static int[][] map = new int[9][9];
    public static int N = 9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        sodoku();
    }
    
    // 게임 시작
    public static void sodoku(){
        int[] idx = findZeroIdx();

        if(idx[0] == -1){
            printSdoku();
            System.exit(0);
        }

        for (int num = 1; num <= 9; num++) {
            if(isValidPosition(idx, num)){
                map[idx[0]][idx[1]] = num;
                sodoku();
                map[idx[0]][idx[1]] = 0;
            }
        }

    }

    // 0인 위치 반환
    public static int[] findZeroIdx(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // 해당 위치에 숫자가 들어갈 수 있나 체크
    public static boolean isValidPosition(int[] idx, int num){
        int i = idx[0];
        int j = idx[1];

        for (int k = 0; k < N; k++) {
            if(map[i][k] == num || map[k][j] == num) return false;
        }

        for(int y = (i/3*3); y < (i/3*3) + 3; y++){
            for(int x = (j/3*3); x < (j/3*3)+ 3; x++){
                if(map[y][x] == num) return false;
            }
        }

        return true;
    }

    // map 출력
    public static void printSdoku(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]+"");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
