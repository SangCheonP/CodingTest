import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 16234 인구 이동(골드4)
https://www.acmicpc.net/problem/16234
 */
public class Baek_16234_인구이동_2 {
    static int N, L, R, day = 0;
    static int[][] pMap;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<Point> unionCity;
    static Queue<Point> queue;

    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        pMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            pMap[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(pMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");

        while (open()){
            day += 1;
            int sumP = 0;

            // 연합의 인구 수 계산
            for (Point p: unionCity){
                sumP += pMap[p.i][p.j];
                System.out.println("pMap: " + pMap[p.i][p.j]);
            }
            System.out.println("sum: " + sumP);

            // 인구 계산
            double ch = Math.floor(sumP/unionCity.size());

            // 인구 이동
            for (Point p: unionCity){
                pMap[p.i][p.j] = (int) ch;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(pMap[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------");

        }

        System.out.println(day);
        
    }
    
    static boolean open(){
        boolean canOpen = false;
        boolean[][] visited = new boolean[N][N];
        unionCity = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // BFS를 돌며 지나간 도시 넣는 배열
                List<Point> tmpCity = new LinkedList<>();
                queue = new ArrayDeque<>();

                // 방문했으면 예외처리
                if(visited[i][j])
                    continue;

                // 방문, 초기 값 넣음
                visited[i][j] = true;
                queue.offer(new Point(i, j));

                while (!queue.isEmpty()){
                    Point cur = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];

                        // 범위 안 + 방문X
                        if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]){
                            int diff = Math.abs(pMap[cur.i][cur.j] - pMap[ni][nj]);
                            // 인구 차이가 범위를 넘어가면 예외 처리
                            if(L <= diff && diff <= R){
                                // 열 수 있다고 변경
                                if(!canOpen)
                                    canOpen = true;

                                // 방문 처리
                                visited[ni][nj] = true;
                                tmpCity.add(new Point(ni, nj));
                                queue.offer(new Point(ni, nj));
                            }
                        }
                    }
                }

                // 열린 구역이 있으면 지나온 도시 연합에 추가
                if(tmpCity.size() > 1) {
//                    for (Point p: tmpCity){
//                        System.out.println("p: " + pMap[p.i][p.j]);
//                    }
                    unionCity.addAll(tmpCity);
                }
            }
        }

        return canOpen;
    }
}
