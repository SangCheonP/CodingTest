import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 14500 테트로미노 - 구현
https://www.acmicpc.net/problem/14500
 */
public class Baek_14500_테트로미노 {
    public static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static int N, M;
    public static Point[] model1_1 = {new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0, 3)};
    public static Point[] model1_2 = {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0)};
    public static Point[] model2 = {new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)};
    public static Point[][] model3_1 = {{new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, 1)},
                                        {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0)},
                                        {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)},
                                        {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(2, 0)}
                                        };

    public static Point[][] model3_2 = {{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(1, 2)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2)},
            {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(1, 2)},
            {new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2)}
    };

    public static Point[][] model4_1 = {{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
                                        {new Point(0, 1), new Point(1, 1), new Point(1, 0), new Point(2, 0)}
    };

    public static Point[][] model4_2 = {{new Point(1, 0), new Point(1, 1), new Point(0, 1), new Point(0, 2)},
                                        {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)}
    };

    public static Point[][] model5_1 = {{new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 1)},
                                        {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 1)}
    };

    public static Point[][] model5_2 = {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 0)},
                                        {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(1, 1)}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = 0;

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // m1 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M-4; j++) {
                int tmp = 0;
                for (Point p : model1_1){
                    tmp += map[i + p.i][j + p.j];
                }
                result = Math.max(tmp, result);
            }
        }

        // m1 1
        for (int i = 0; i <= N-4; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = 0;
                for (Point p : model1_2){
                    tmp += map[i + p.i][j + p.j];
                }
                result = Math.max(tmp, result);
            }
        }

        // m2
        for (int i = 0; i <= N-2; i++) {
            for (int j = 0; j <= M-2; j++) {
                int tmp = 0;
                for (Point p : model2) {
                    tmp += map[i + p.i][j + p.j];
                }
                result = Math.max(tmp, result);
            }
        }

        // m3의 1/3/5/7 방향
        for (int i = 0; i <= N-3; i++) {
            for (int j = 0; j <= M-2; j++) {
                for (Point[] ps : model3_1){
                    int tmp = 0;
                    for (Point p : ps){
                        tmp += map[i + p.i][j + p.j];
                    }
                    result = Math.max(tmp, result);
                }
            }
        }

        // m3의 2/4/6/8 방향
        for (int i = 0; i <= N-2; i++) {
            for (int j = 0; j <= M-3; j++) {
                for (Point[] ps : model3_2){
                    int tmp = 0;
                    for (Point p : ps){
                        tmp += map[i + p.i][j + p.j];
                    }
                    result = Math.max(tmp, result);
                }
            }
        }

        // m4의 1/3 방향
        for (int i = 0; i <= N-3; i++) {
            for (int j = 0; j <= M-2; j++) {
                for (Point[] ps : model4_1){
                    int tmp = 0;
                    for (Point p : ps){
                        tmp += map[i + p.i][j + p.j];
                    }
                    result = Math.max(tmp, result);
                }
            }
        }

        // m4의 2/4 방향
        for (int i = 0; i <= N-2; i++) {
            for (int j = 0; j <= M-3; j++) {
                for (Point[] ps : model4_2){
                    int tmp = 0;
                    for (Point p : ps){
                        tmp += map[i + p.i][j + p.j];
                    }
                    result = Math.max(tmp, result);
                }
            }
        }

        // m5의 1/3 방향
        for (int i = 0; i <= N-2; i++) {
            for (int j = 0; j <= M-3; j++) {
                for (Point[] ps : model5_1){
                    int tmp = 0;
                    for (Point p : ps){
                        tmp += map[i + p.i][j + p.j];
                    }
                    result = Math.max(tmp, result);
                }
            }
        }

        // m5의 2/4 방향
        for (int i = 0; i <= N-3; i++) {
            int tmp = 0;
            for (int j = 0; j <= M-2; j++) {
                for (Point[] ps : model5_2){
                    tmp = 0;
                    for (Point p : ps){
                        tmp += map[i + p.i][j + p.j];
                    }
                    result = Math.max(tmp, result);
                }
            }
        }

        System.out.println(result);
    }
}
