import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 17135 캐슬 디펜스 (골드3)
https://www.acmicpc.net/problem/17135
 */
public class Baek_17135 {
    public static int N, M, D, result;
    public static boolean[][] map;
    public static int[] di = {-1, 0, 0};
    public static int[] dj = {0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 행 / M: 열 / D: 공격 거리 제한(D이하)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    map[i][j] = true;
            }
        }
        result = 0;
        comb(0, 0);
    }

    public static void comb(int idx, int cnt){
        if(cnt == 3){
            int tmp = 0;
            boolean[][] cp = new boolean[N+1][M];
            for (int i = 0; i < N+1; i++) {
                for (int j = 0; j < M; j++) {
                    cp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                print(cp);
                // 공격
                tmp += att(cp);
                // 이동
                move(cp);    
            }

            result = Math.max(result, tmp);
            return;
        }
        if(idx == M){
            return;
        }

        map[N][idx] = true;
        comb(idx+1, cnt+1);
        map[N][idx] = false;
        comb(idx+1, cnt);

    }

    public static class Enemy{
        int i;
        int j;

        public Enemy(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    // 공격
    public static int att(boolean[][] cp){
        boolean[][] selectEm = new boolean[N][M];
        Queue<Enemy> queue = new ArrayDeque<>();
        int size = 0, curDis = 0, tmp = 0;

        System.out.println("att");

        // 궁수가 있는 줄에서
        for (int j = 0; j < M; j++) {
            // 궁수마다, 해당 위치에서 BFS 진행
            if(cp[N][j] == true){
                queue.offer(new Enemy(N-1, j));

                size = queue.size();

                out: while (!queue.isEmpty()){
                    while (--size >= 0 && ++curDis <= D){
                        Enemy cur = queue.poll();
                        // 해당 위치에 적이 있으면
                        if(cp[cur.i][cur.j]){
                            // 그 위치 적을 선택 표시
                            if(!selectEm[cur.i][cur.j]){
                                selectEm[cur.i][cur.j] = true;
                                tmp += 1;
                                break out;
                            }

                        // 적이 없으면
                        }else {
                            for (int d = 0; d < 3; d++) {
                                int ni = cur.i + di[d];
                                int nj = cur.j + dj[d];

                                if(0 <= ni && ni < N && 0 <= nj && nj < M){
                                    queue.offer(new Enemy(ni, nj));
                                }
                            }
                        }
                    }

                    size = queue.size();
                }
            }
        }
        // 선택한 적 제거
        for (int z = 0; z < N; z++) {
            for (int x = 0; x < M; x++) {
                if(selectEm[z][x])
                    map[z][x] = false;
            }
        }
        return tmp;
    }

    // 적들 아래로 한 칸 이동
    public static void move(boolean[][] cp){
        System.out.println("move");
        for (int i = N-1; i >= 1 ; i--) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = cp[i-1][j];
            }
        }
        for (int j = 0; j < M; j++) {
            cp[0][j] = false;
        }
    }

    public static void print(boolean[][] cp){
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(cp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
