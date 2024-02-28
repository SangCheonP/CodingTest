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
    // 크기, 최대 코어 연결 개수, 최대 코어 연결 방법 중 최소 전선 길이
    static int N, maxCnt, result;
    // 상하좌우
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    // 0: 빈 칸, 1: 코어, 2: 전원 연결한 코어
    static int[][] map;
    static List<int[]> coreList;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            // 전원에 연결할 코어 리스트
            coreList = new ArrayList<>();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 각 변이면
                    if (i == 0 || j == 0 || i == N-1 || j == N-1) continue;
                    // 전원에 연결이 필요한 코어 추가
                    if (map[i][j] == 1) coreList.add(new int[]{i, j});
                }
            }

            result = 0;
            maxCnt = 0;

            backtracking(0, 0, 0);

            System.out.println("#" + tc + " " + result);
        }


    }

    static void backtracking(int idx, int len, int cnt){
        // idx: 이번에 선택한 코어 번호
        // len: 지금까지 사용한 전선의 총 길이
        // cnt: 지금까지 연결한 코어의 개수
        // 더 많은 코어를 연결시
        if(cnt > maxCnt){
            maxCnt = cnt;
            result = len;
        // 같은 수의 코어 연결시
        } else if (cnt == maxCnt) {
            result = Math.min(result, len);
        }
        
        // 코어 다 보면
        if(idx == coreList.size()){
            return;
        }

        for (int d = 0; d < 4; d++) {
            int wireLen = extend(coreList.get(idx), d);

            // 해당 방향으로는 전원까지 갈 수 없으면
            if(wireLen == -1){
                continue;
            }

            // 다음 코어 보러감
            backtracking(idx + 1, len + wireLen, cnt + 1);
            rollback(coreList.get(idx), d);
        }

        // 다음 코어부터 시작
        backtracking(idx + 1, len, cnt);
    }

    static void rollback(int[] point, int d){
        int i = point[0] + di[d];
        int j = point[1] + dj[d];

        while (0 <= i && i < N && 0 <= j && j < N){
            map[i][j] = 0;
            i += di[d];
            j += dj[d];
        }
    }

    static int extend(int[] point, int d){
        int i = point[0] + di[d];
        int j = point[1] + dj[d];
        int res = 0;

        // 끝까지 갈 수 있는 지 체크
        while (0 <= i && i < N && 0 <= j && j < N){
            // 빈 칸이 아니면
            if(map[i][j] != 0){
                return -1;
            }
            
            i += di[d];
            j += dj[d];
        }

        i = point[0] + di[d];
        j = point[1] + dj[d];

        // 전선 설치
        while (0 <= i && i < N && 0 <= j && j < N){
            map[i][j] = 2;
            i += di[d];
            j += dj[d];
            res++;
        }

        return res;
    }

}
