package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_17070_파이프옮기기1 {
    static int N, cnt;
    static int[][] map;

    // 가로: 0 / 세로: 1 / 대각선: 2
    // 좌표 모음에 첫 번째 좌표의 [2] 즉, 3번째 수는 파이프의 type
    // 좌표 모음의 첫 번째 좌표 배열이 다음 dfs 시작 지점
    // [ 가로세로대각선 ] / [ 방향 가지 ] / [ 좌표의 모음 ] / [좌표]
    static int[][][][] position = {{{{0, 1, 0}}, {{1, 1, 2}, {0, 1}, {1, 0}}}, // 가로
                                    {{{1, 0, 1}}, {{1, 1, 2}, {0, 1}, {1, 0}}}, // 세로
                                    {{{0, 1, 0}}, {{1, 0, 1}}, {{1, 1, 2}, {0, 1}, {1, 0}}}}; // 대각선
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 1, 0);

        System.out.println(cnt);
    }

    static void dfs(int i, int j, int type){
        // 도착하면
        if(i == N-1 && j == N-1){
            cnt += 1;
            return;
        }

        // 해당 파이프 type이 가능한 가지 수 동안
        for (int[][] dirType: position[type]){
            int clear = 0;
            // 각 방향의 idx 모음을 돌며 빈칸 수 체크
            for (int[] idx: dirType){
                int ni = i + idx[0];
                int nj = j + idx[1];
                
                // 범위 안
                if (0 <= ni && ni < N && 0 <= nj && nj < N){
                    // 빈칸
                    if(map[ni][nj] == 0)
                        clear += 1;
                }
            }
            // 해당 파이프 type에 다음 빈칸이 있으면
            if(dirType.length == clear){
                // 파이프 옮김
                dfs(i + dirType[0][0], j + dirType[0][1], dirType[0][2]);
            }
        }
    }
}
