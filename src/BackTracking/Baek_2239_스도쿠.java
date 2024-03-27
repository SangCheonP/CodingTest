package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_2239_스도쿠 {
    public static int[][] map = new int[9][9];
    public static int N = 9;
    public static boolean fin = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        out:for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 0)
                    continue;

                backTracking(i, j);

                break out;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    // 1 ~ 9
    // 행 체크 
    // 열 체크
    // 작은 사각형 체크
    // 
    
    
    public static void backTracking(int i, int j){
        ckEnd();

        if(fin){
            return;
        }

        out: for(int num = 1; num <= 9; num++){
            // 행 체크
            for(int x = 0; x < N; x++){
                if(map[i][x] == num)
                    continue out;
            }

            // 열 체크
            for(int y = 0; y < N; y++){
                if(map[y][j] == num)
                    continue out;
            }

            // 3x3 체크
            for(int y = (i/3*3); y < (i/3*3) + 3; y++){
                for(int x = (j/3*3); x < (j/3*3)+ 3; x++){
                    if(map[y][x] == num)
                        continue out;
                }
            }

            // 다 체크했는데 해당 숫자 사용가능 -> 숫자 놓음
            map[i][j] = num;

            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    if(map[r][c] == 0){
                        System.out.println("여기");
                        backTracking(r, c);
                    }
                }
            }

            map[i][j] = 0;
        }
    }

    public static void ckEnd(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    return;
                }
            }
        }
        fin = true;
    }
}
