package SubSet;
/*
백준 17471 게리맨더링(골드4) - 부분 집합, BFS
https://www.acmicpc.net/problem/15683
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_17471_게리맨더링 {
    static int N, result;
    // 구역을 나눌 수 있는지
    static boolean canDiv;
    // 인구수 배열
    static int[] person;
    // 인접한 정점 배열
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N: 구역의 개수 1 ~ N
        N = Integer.parseInt(br.readLine());

        // 인구 수 1 ~ N
        person = new int[N+1];
        // 1 ~ N까지
        map = new boolean[N+1][N+1];

        List<Integer> area1 = new LinkedList<>();
        List<Integer> area2 = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        // 인구수 저장
        for (int i = 1; i < N+1; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }
        
        // 인접한 정점 저장
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int ed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < ed; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][tmp] = true;
            }
        }

        result = Integer.MAX_VALUE;
        canDiv = false;

        // 1번 구역 포함하여 부분 집합
        subSet(1, 1, area1, area2);

        // 나눌 수 없으면
        if(!canDiv)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    static void subSet(int idx, int cnt, List<Integer> area1, List<Integer> area2){
        if(cnt == N+1)
            return;
        // 부분 집합이 만들어 졌으면
        if(idx == N+1){
            // 각 영역이 최소 한 개 이상일 때
            if(area1.size() < 1 || area2.size() < 1)
                return;

            int p1 = isConnect(area1);
            int p2 = isConnect(area2);

            // 1구역들과 2구역들이 각각 연결되어 있으면
            if(p1 != -1 && p2 != -1){
                result = Math.min(result, Math.abs(p1 - p2));
                if(!canDiv)
                    canDiv = true;
            }
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

    // area1이 연결 -> 총 인구수 반환 / 연결X -> -1 반환
    static int isConnect(List<Integer> area){
        // area배열에 들어있는 정점들을 방문했는지 검사
        boolean[] checkVisited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        // idx: 현재 방문한 정점 개수 / p: 인구수
        int idx = 0, p = 0;

        checkVisited[area.get(idx)] = true;
        p += person[area.get(idx)];
        queue.add(area.get(idx++));

        while (!queue.isEmpty()){
            int cur = queue.poll();

            for (int i = 1; i < N+1; i++) {
                // 내 영역 + 연결 + 방문X
                if(area.contains(i) && map[cur][i] && !checkVisited[i]){
                    checkVisited[i] = true;
                    p += person[i];
                    queue.add(i);
                    idx++;
                }
            }
        }

        // 방문한 정점 개수 == 구역 사이즈 -> 연결
        if(idx == area.size())
            return p;
        return -1;
    }
}
