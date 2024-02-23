import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 16234 인구이동(골드4)
https://www.acmicpc.net/problem/16234
 */
public class Baek_16234_인구이동 {
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static int[][] map;
    public static int N, L, R, result;
    public static List<Point> cityList;
    public static class Point{
        int i, j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // L <= 인구 차이 <= R
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        boolean[][] visited;
        int sumPerson, result = 0;

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 모든 좌표를 방문하며
        cityList = new ArrayList<>();
        while (open()){
            sumPerson = 0;
            result += 1;
            for (Point p: cityList){
                sumPerson += map[p.i][p.j];
            }
            System.out.println(sumPerson);
            System.out.println(cityList.size());
            for (Point p: cityList){
                System.out.println(map[p.i][p.j]);
                map[p.i][p.j] = (int)Math.floor(sumPerson/cityList.size());
            }
            cityList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("----------------");
        }

        System.out.println(result);
    }

    private static boolean open() {
        List<Point> tmpList = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        boolean canDiv = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 연합에 들어가는 도시 idx
                //cityList = new ArrayList<>();
                // 연합의 총 인구수
                //sumPerson = 0;
                // 방문했으면 다음 좌표로 넘어감
                if(visited[i][j]){
                   continue;
                }

                Queue<Point> queue = new ArrayDeque<>();

                // 방문했다 체크
                visited[i][j] = true;
                tmpList.add(new Point(i, j));
                queue.add(new Point(i, j));

                while (!queue.isEmpty()){
                    Point cur = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];

                        // 범위 안 + 방문X + L <= 인구수 차이 <= R
                        if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]){
                            if(L <= Math.abs(map[cur.i][cur.j] - map[ni][nj]) && Math.abs(map[cur.i][cur.j] - map[ni][nj]) <= R){
                                visited[ni][nj] = true;
                                tmpList.add(new Point(ni, nj));
                                queue.add(new Point(ni, nj));
                            }
                        }
                    }
                }

                if(tmpList.size() > 1){
                    canDiv = true;
                    for (Point p: tmpList){
                        cityList.add(p);
                    }
                }
                tmpList = new ArrayList<>();
            }
        }
        return canDiv;
    }
}
