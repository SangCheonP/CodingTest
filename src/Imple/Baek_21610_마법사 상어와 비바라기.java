/*
 N*N 격자
 A[r][c] -> r행 c열 바구니에 들은 물의 양
 (1, 1) ~ (N, N)
 비바라기 -> (N,1), (N,2), (N-1,1), (N-1,2)
 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
 1  2  3  4  5  6  7  8

 1. 모든 구름 이동
 2. 구름이 있는 칸 바구니 물의 양 + 1
 3. 구름 사라짐
 4. 2에서 물이 증가한 칸(구름이 있는 칸) 물복사버그 마법
    대각선 방향의 1거리에 있는 물이 있는 바구니 수만큼 (r, c)에 있는 바구니 물의 양 증가
    * 경계를 넘어가는 칸은 제외
 5. 바구니의 물의 양이 2 >= 구름 생성, 물의 양 -2
    * 구름이 있던 곳을 제외하고 나머지에서

 시간 제한 : 1초
 메모리 제한 : 1024MB
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 격자칸의 크기
        // M : 이동 횟수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 바구니 물의 양을 저장할 배열
        int[][] map = new int[N+1][N+1];

        // 맵 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구름
        boolean[][] cloudes = new boolean[N+1][N+1];

        // 초기 구름
        cloudes[N][1] = true;
        cloudes[N][2] = true;
        cloudes[N-1][1] = true;
        cloudes[N-1][2] = true;
        
        // 이동 방향과 거리를 받음
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // 구름 이동
            MoveCloudes(d, s, cloudes);

            // 구름이 있는 위치의 바구니의 물의 양 증가
            UpdateWater(map, cloudes);

            // 구름이 있는 위치에 물복사버그 마법
            WaterCopyBug(map, cloudes);
            
            // 구름이 있던 곳을 제외하고, 구름 생성
            MakeCloudes(map, cloudes);
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
    }

    // 방향 배열
    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    // 1  2  3  4  5  6  7  8
    static int[] di = {0, 0, -1, -1, -1, 0, 1, 1, 1}; // 행 이동 (상, 하)
    static int[] dj = {0, -1, -1, 0, 1, 1, 1, 0, -1}; // 열 이동 (좌, 우)

    // 구름 이동 함수
    static void MoveCloudes(int d, int s, boolean[][] cloudes) {
        boolean[][] newCloudes = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloudes[i][j]) {
                    // 이동 후 위치 계산
                    int ni = (i + di[d] * s) % N;
                    int nj = (j + dj[d] * s) % N;

                    if (ni <= 0) ni += N;
                    if (nj <= 0) nj += N;

                    newCloudes[ni][nj] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cloudes[i][j] = newCloudes[i][j];
            }
        }
    }

    // 구름이 있는 위치의 물의 양 증가
    static void UpdateWater(int[][] map, boolean[][] cloudes) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 구름이 있는 위치라면 물의 양 증가
                if (cloudes[i][j]) {
                    map[i][j] += 1;
                }
            }
        }
    }

    // 물복사버그 마법
    static void WaterCopyBug(int[][] map, boolean[][] cloudes) {
        // 대각선 방향 정의
        int[] diagRow = {-1, -1, 1, 1}; // ↖, ↗, ↘, ↙
        int[] diagCol = {-1, 1, 1, -1};

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloudes[i][j]) {
                    int waterCount = 0;

                    // 대각선 방향 탐색
                    for (int d = 0; d < 4; d++) {
                        int ni = i + diagRow[d];
                        int nj = j + diagCol[d];

                        // 경계 확인 및 물이 있는지 체크
                        if(1 <= ni && ni <= N && 1 <= nj && nj <= N && map[ni][nj] >= 1) {
                            waterCount += 1;
                        }
                    }

                    // 대각선 물의 개수만큼 현재 칸의 물 증가
                    map[i][j] += waterCount;
                }
            }
        }
    }

    // 새 구름을 만드는 함수
    static void MakeCloudes(int[][] map, boolean[][] cloudes) {
        boolean[][] newCloudes = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 물의 양이 2 이상이고, 기존에 구름이 없었던 위치에 구름 생성
                if (map[i][j] >= 2 && !cloudes[i][j]) {
                    newCloudes[i][j] = true;
                    map[i][j] -= 2; // 물의 양 감소
                }
            }
        }

        // 새로 만들어진 구름을 복사
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cloudes[i][j] = newCloudes[i][j];
            }
        }
    }
}
