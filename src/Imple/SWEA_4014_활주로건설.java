package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            boolean canSet = true;

            // 가로 검사
            for (int i = 0; i < N; i++) {
                canSet = true;
                out:
                for (int j = 1; j < N; j++) {
                    // 전 칸이랑 높이가 같으면 다음 칸으로
                    if(map[i][j-1] == map[i][j]) continue;
                    // 2칸이상 차이나면 해당 경사로에 건설 불가
                    if(Math.abs(map[i][j-1] - map[i][j]) > 1) break out;

                    // 왼쪽이 더 높을 때
                    if(map[i][j-1] > map[i][j]){
                        for (int k = j+1; k < j+X; k++) {
                            if(k < N){

                            }else{
                                break out;
                            }
                        }
                    // 오른쪽이 더 높을 때
                    }else{
                        // 놓을 수 없으면
                        canSet = false;
                        break;
                    }
                }
                if(canSet){
                    result += 1;
                }
            }

            // 세로 검사
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {

                }
            }


            System.out.println("#" + tc + " " + result);
        }
    }
}
