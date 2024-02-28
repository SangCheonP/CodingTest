package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
SWEA 1767 프로세스 연결하기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
 */
public class SWEA_1767_프로세스연결하기 {
    // 크기, 전원 연결한 코어 수, 체크하는 코어 idx
    static int N, len, result;
    // 상하좌우
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    // 0: 빈 칸, 1: 코어, 2: 전원 연결한 코어
    static int[][] map;
    static List<Point> cores;

    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());

            len = 0;
            result = Integer.MAX_VALUE;

            // 전원 연결이 필요한 코어 리스트
            cores = new ArrayList<>();
            map = new int[N][N];


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if(tmp == 1){
                        if(i == 0 || j == 0 || i == N-1 || j == N-1){
                            map[i][j] = 2;
                        }else{
                            map[i][j] = 1;
                            cores.add(new Point(i, j));
                        }
                    }else{
                        map[i][j] = tmp;
                    }
                }
            }

            dfs(cores.get(0).i, cores.get(0).j, map, 0, 1);

            System.out.println("#" + tc + " " + result);
        }

    }

    static void dfs(int i, int j, int[][] map, int sum, int idx){

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            // 진행 길이
            int tmpLen = 0;

            // 한 뱡향으로 쭉
            while(0 <= ni && ni < N && 0 <= nj && nj < N){
                if(map[ni][nj] == 2 || map[ni][nj] == 1 || map[ni][nj] == -1) break;
                tmpLen += 1;

                if(d == 0){ // 상
                    // 끝가지 도달하면
                    if(tmpLen == i){
                        // map 채우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i-k][j] = -1;
                        }
                        printMap();

                        if(idx == cores.size()){
                            result = Math.min(result, sum);
                            // map 비우기
                            for (int k = 1; k <= tmpLen; k++) {
                                map[i-k][j] = 0;
                            }
                            return;
                        }

                        System.out.println("상");
                        System.out.println("ni: " + ni + ", nj: " + nj + ", tmpLen: " + tmpLen + ", idx: " + idx + ", sum: " + sum + ", result: " + result);
                        System.out.println("------------------------------------");

                        // dfs
                        dfs(cores.get(idx).i, cores.get(idx).j, map, sum + tmpLen, idx+1);

                        // map 비우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i-k][j] = 0;
                        }
                    }
                } else if (d == 1) { // 하
                    if(tmpLen == N - 1 - i){
                        // map 채우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i+k][j] = -1;
                        }
                        printMap();

                        if(idx == cores.size()){
                            result = Math.min(result, sum);
                            // map 비우기
                            for (int k = 1; k <= tmpLen; k++) {
                                map[i+k][j] = 0;
                            }

                            return;
                        }

                        System.out.println("하");
                        System.out.println("ni: " + ni + ", nj: " + nj + ", tmpLen: " + tmpLen + ", sum: " + sum + ", result: " + result);
                        System.out.println("------------------------------------");

                        // dfs
                        dfs(cores.get(idx).i, cores.get(idx).j, map, sum + tmpLen, idx+1);

                        // map 비우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i+k][j] = 0;
                        }
                    }
                } else if (d == 2) { // 좌
                    if(tmpLen == j){

                        // map 채우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i][j-k] = -1;
                        }
                        printMap();

                        if(idx == cores.size()){
                            result = Math.min(result, sum);
                            // map 비우기
                            for (int k = 1; k <= tmpLen; k++) {
                                map[i][j-k] = 0;
                            }
                            return;
                        }

                        System.out.println("좌");
                        System.out.println("ni: " + ni + ", nj: " + nj + ", tmpLen: " + tmpLen + ", sum: " + sum + ", result: " + result);
                        System.out.println("------------------------------------");

                        // dfs
                        dfs(cores.get(idx).i, cores.get(idx).j, map, sum + tmpLen, idx+1);

                        // map 비우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i][j-k] = 0;
                        }
                    }
                } else if (d == 3) { // 우
                    if(tmpLen == N - 1 - j){
                        // map 채우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i][j+k] = -1;
                        }
                        printMap();

                        // 모든 코어 연결시
                        if(idx == cores.size()){
                            result = Math.min(result, sum);
                            // map 비우기
                            for (int k = 1; k <= tmpLen; k++) {
                                map[i][j+k] = 0;
                            }
                            return;
                        }

                        System.out.println("우");
                        System.out.println("ni: " + ni + ", nj: " + nj + ", tmpLen: " + tmpLen + ", sum: " + sum + ", result: " + result);
                        System.out.println("------------------------------------");

                        // dfs
                        dfs(cores.get(idx).i, cores.get(idx).j, map, sum + tmpLen, idx+1);

                        // map 비우기
                        for (int k = 1; k <= tmpLen; k++) {
                            map[i][j+k] = 0;
                        }
                    }
                }

                ni += di[d];
                nj += dj[d];
            }
        }
    }


    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
