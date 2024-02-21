import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 15683 감시(골드4)
https://www.acmicpc.net/problem/15683
 */
public class Baek_15683_감시 {
    public static int N, M, result;
    public static char[][] map;
    public static List<Point> cctvs;
    public static List<Point> cctv5;
    public static int[] di = {-1, 0, 1, 0};
    public static int[] dj = {0, 1, 0, -1};

    // 좌 / 상
    public static int[] di2 = {0, -1};
    public static int[] dj2 = {-1, 0};

    public static class Point{
        int i;
        int j;
        char type;
        Point(int i, int j, char type){
            this.i = i;
            this.j = j;
            this.type = type;
        }

        @Override
        public String toString(){
            return "Point i: " + i + ", j: " + j + ", type: " + type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;

        map = new char[N][M];
        // 5번을 제외한 나머지 cctv
        cctvs = new ArrayList<>();
        // 5번 cctv
        cctv5 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                // 빈 칸 and 벽이 아니면
                if(map[i][j] != '0' && map[i][j] != '6'){
                    // 5번 cctv가 아니면
                    if(map[i][j] != '5'){
                        cctvs.add(new Point(i, j, map[i][j]));
                    // 5번 cctv면
                    }else{
                        cctv5.add(new Point(i, j, map[i][j]));
                    }
                }
            }
        }


        char[][] cp = new char[N][M];

        cpArr(map, cp);

        comb(0, cp);

        System.out.println(result);
    }

    
    // 5번 cctv 초기화
    private static void setCctv5(char[][] cp) {
        for (int i = 0; i < cctv5.size(); i++) {
            Point cur = cctv5.get(i);

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                // 범위 안에 있고, 벽이 아니면
                while(0 <= ni && ni < N && 0 <= nj && nj < M && cp[ni][nj] != '6'){
                    // 빈 칸이면
                    if(cp[ni][nj] == '0'){
                        cp[ni][nj] = '#';
                    }
                    ni += di[d];
                    nj += dj[d];
                }
            }
        }
    }

    private static void cpArr(char[][] map, char[][] cp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = map[i][j];
            }
        }
    }

    public static void comb(int idx, char[][] cp){
        // 조합이 만들어지면
        if(idx == cctvs.size()){
            // 5번 cctv 설정
            setCctv5(cp);
            // 사각지대 개수
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(cp[i][j] == '0')
                        tmp+=1;
                }
            }
            
            // 최소로 초기화
            result = Math.min(result, tmp);
            return;
        }
        
        switch (cctvs.get(idx).type){
            case '1':
                // 4방향 진행
                for (int d = 0; d < 4; d++) {
                    // 사용할 배열
                    char[][] useCp = new char[N][M];
                    // useCp에 cp 복사
                    cpArr(cp, useCp);

                    int ni = cctvs.get(idx).i + di[d];
                    int nj = cctvs.get(idx).j + dj[d];

                    // 범위 안에 있고, 벽이 아니면
                    while(0 <= ni && ni < N && 0 <= nj && nj < M && useCp[ni][nj] != '6'){
                        // 빈 칸이면
                        if(useCp[ni][nj] == '0'){
                            useCp[ni][nj] = '#';
                        }
                        ni += di[d];
                        nj += dj[d];
                    }
                    comb(idx + 1, useCp);
                }
                break;

            case '2':
                for (int d = 0; d < 2; d++) {
                    // 사용할 배열
                    char[][] useCp = new char[N][M];
                    // useCp에 cp 복사
                    cpArr(cp, useCp);

                    // 좌 / 상
                    int ni1 = cctvs.get(idx).i + di2[d]; // 0
                    int nj1 = cctvs.get(idx).j + dj2[d]; // -1

                    // 우 / 하
                    int ni2 = cctvs.get(idx).i + (-1 * di2[d]); // 0
                    int nj2 = cctvs.get(idx).j + (-1 * dj2[d]); // 1

                    // 범위 안에 있고, 벽이 아니면
                    while(0 <= ni1 && ni1 < N && 0 <= nj1 && nj1 < M && useCp[ni1][nj1] != '6'){
                        // 빈 칸이면
                        if(useCp[ni1][nj1] == '0'){
                            useCp[ni1][nj1] = '#';
                        }
                        ni1 += di2[d];
                        nj1 += dj2[d];
                    }

                    while(0 <= ni2 && ni2 < N && 0 <= nj2 && nj2 < M && useCp[ni2][nj2] != '6'){
                        // 빈 칸이면
                        if(useCp[ni2][nj2] == '0'){
                            useCp[ni2][nj2] = '#';
                        }
                        ni2 += (-1 * di2[d]);
                        nj2 += (-1 * dj2[d]);
                    }
                    comb(idx + 1, useCp);
                }
                break;

            case '3':
                for (int d = 0; d < 4; d++) {
                    // 사용할 배열
                    char[][] useCp = new char[N][M];
                    // useCp에 cp 복사
                    cpArr(cp, useCp);

                    // 좌 / 하
                    int ni1 = cctvs.get(idx).i + di[d]; // 0
                    int nj1 = cctvs.get(idx).j + dj[d]; // -1

                    // 우 / 좌
                    int ni2 = cctvs.get(idx).i + di[(d+1)%4]; // 0
                    int nj2 = cctvs.get(idx).j + dj[(d+1)%4]; // 1

                    // 범위 안에 있고, 벽이 아니면
                    while(0 <= ni1 && ni1 < N && 0 <= nj1 && nj1 < M && useCp[ni1][nj1] != '6'){
                        // 빈 칸이면
                        if(useCp[ni1][nj1] == '0'){
                            useCp[ni1][nj1] = '#';
                        }
                        ni1 += di[d];
                        nj1 += dj[d];
                    }

                    while(0 <= ni2 && ni2 < N && 0 <= nj2 && nj2 < M && useCp[ni2][nj2] != '6'){
                        // 빈 칸이면
                        if(useCp[ni2][nj2] == '0'){
                            useCp[ni2][nj2] = '#';
                        }
                        ni2 += di[(d+1)%4];
                        nj2 += dj[(d+1)%4];
                    }
                    comb(idx + 1, useCp);
                }
                break;

            case '4':
                for (int d = 0; d < 4; d++) {
                    // 사용할 배열
                    char[][] useCp = new char[N][M];
                    // useCp에 cp 복사
                    cpArr(cp, useCp);
                    
                    // 3방향에 대해서 채움
                    int ni = cctvs.get(idx).i + di[d];
                    int nj = cctvs.get(idx).j + dj[d];

                    int ni2 = cctvs.get(idx).i + di[(d+1)%4];
                    int nj2 = cctvs.get(idx).j + dj[(d+1)%4];

                    int ni3 = cctvs.get(idx).i + di[(d+2)%4];
                    int nj3 = cctvs.get(idx).j + dj[(d+2)%4];

                    // 범위 안에 있고, 벽이 아니면
                    while(0 <= ni && ni < N && 0 <= nj && nj < M && useCp[ni][nj] != '6'){
                        // 빈 칸이면
                        if(useCp[ni][nj] == '0'){
                            useCp[ni][nj] = '#';
                        }
                        ni += di[d];
                        nj += dj[d];
                    }

                    while(0 <= ni2 && ni2 < N && 0 <= nj2 && nj2 < M && useCp[ni2][nj2] != '6'){
                        // 빈 칸이면
                        if(useCp[ni2][nj2] == '0'){
                            useCp[ni2][nj2] = '#';
                        }
                        ni2 += di[(d+1)%4];
                        nj2 += dj[(d+1)%4];
                    }

                    while(0 <= ni3 && ni3 < N && 0 <= nj3 && nj3 < M && useCp[ni3][nj3] != '6'){
                        // 빈 칸이면
                        if(useCp[ni3][nj3] == '0'){
                            useCp[ni3][nj3] = '#';
                        }
                        ni3 += di[(d+2)%4];
                        nj3 += dj[(d+2)%4];
                    }
                    comb(idx + 1, useCp);
                }
                break;
        }
    }
}
