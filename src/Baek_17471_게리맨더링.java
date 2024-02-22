import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_17471_게리맨더링 {
    static int N;
    static int[] person;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N: 구역의 개수 1 ~ N
        N = Integer.parseInt(br.readLine());

        // 인구 수 1 ~ N
        person = new int[N+1];
        // 1 ~ N까지
        visited = new boolean[N+1][N+1];

        List<Integer> area1 = new LinkedList<>();
        List<Integer> area2 = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int ed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < ed; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                visited[i][tmp] = true;
            }
        }

        // 1번 구역 포함
        subSet(1, 1, area1, area2);

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void subSet(int idx, int cnt, List<Integer> area1, List<Integer> area2){
        if(cnt == N+1)
            return;
        // 부분 집합을 만들었고, 최소 한 개는 남겼을 때
        if(idx == N+1){
            if(area1.size() < 1 || area2.size() < 1)
                return;
            System.out.println("area1");
            for (int i = 0; i < area1.size(); i++) {
                System.out.print(area1.get(i) + " ");
            }
            System.out.println();

            System.out.println("area2");
            for (int i = 0; i < area2.size(); i++) {
                System.out.print(area2.get(i) + " ");
            }
            System.out.println();
            System.out.println("---------------");
            return;
        }

        // 선택
        area1.add(idx);
        subSet(idx+1, cnt+1, area1, area2);

        // 선택X
        area1.remove(area1.size()-1);
        area2.add(idx);
        subSet(idx+1 , cnt, area1, area2);
        area2.remove(area2.size()-1);
    }

    static boolean isConnect(List<Integer> area){

    }
}
