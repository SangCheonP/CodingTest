package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17136 색종이붙이기(골드2)
 * https://www.acmicpc.net/problem/17136
 */
public class Baek_17136_색종이붙이기 {
    static int result = Integer.MAX_VALUE, N = 10;
    static boolean canMake = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[10][10];
        int[] paperCnt = new int[]{0, 5, 5, 5, 5, 5};
        int oneCnt = 0;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) oneCnt++;
            }
        }

        setPaper(paperCnt, map, oneCnt);

        System.out.println(canMake ? result : -1);
    }

    public static void setPaper(int[] paperCnt, int[][] map, int oneCnt){
        // 5개보다 많이 놓으면 백트레킹
        for (int n: paperCnt){
            if(n < 0) return;
        }

        // 모두 0인지 체크
        if(oneCnt == 0 && fin(map)){
            int min = 0;
            for (int i = 1; i <= 5; i++) {
                min += (5 - paperCnt[i]);
            }
            result = Math.min(result, min);
            canMake = true;
            return;
        }


        int[][] newMap = new int[10][10];
        copy(map, newMap);

        out:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(newMap[i][j] == 0)continue;

                for (int s = 5; s >= 1; s--) {
                    copy(map, newMap);
                    // 5짜리 놓을 수 있는 지 체크
                    if(ckeckSet(i, j, s, newMap) && oneCnt >= Math.pow(s, 2)){
                        // 놓을 수 있으면 놓고 다음 단계로
                        set(i, j, s, newMap);
                        //print(newMap);
                        paperCnt[s] -= 1;
                        setPaper(paperCnt, newMap, (int) (oneCnt - Math.pow(s, 2)));
                        // 모든 가지 수를 해보고 왔으면
                        paperCnt[s] += 1;
                    }
                }
                // 놓을 수 없으면
                return;
            }
        }

    }

    public static boolean fin(int[][] map){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static void set(int i, int j, int size, int[][] map){
        for (int k = i; k < i+size; k++) {
            for (int l = j; l < j+size; l++) {
                map[k][l] = 0;
            }
        }
    }

    public static boolean ckeckSet(int i, int j, int size, int[][] map){
        // 범위 초과
        if(i + size > N || j + size > N) return false;

        // 중간에 0이 있으면
        for (int k = i; k < i+size; k++) {
            for (int l = j; l < j+size; l++) {
                if(map[k][l] == 0) return false;
            }
        }

        return true;
    }

    public static void copy(int[][] map, int[][] newMap){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }
}
