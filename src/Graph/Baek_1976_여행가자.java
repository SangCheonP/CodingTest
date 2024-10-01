package Graph;

/**
 * N개의 도시
 * 두 도시 사이 길O or 길X
 * 주어진 여행 경로가 가능한지
 * 다른 경로를 경유해서 갈 수O
 * 같은 도시 여러번 가능
 *
 * N <= 200 도시의 수
 * M <= 1000 여행 계획에 속한 도시들의 수
 *
 * 도시 번호: 1 ~ N
 *
 * 1: 연결 / 0: 연결X
 * A와 B 연결 -> B와 A도 연결
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 연결 리스트로 관리
 * DFS로 해당 지역에 갈 수 있는지 체크
 * 갈 수 있면 다음 지역 진행
 * 갈 수 없으면 종료
 */

/**
 * 1. 현재 노드, 다음 노드, 방문체크를 파라미터로 DFS 함수를 만들어 갈 수 있는지 체크
 * 2. 단순히 연결 가능 여부만을 확인하므로, 한 번 방문한 노드는 다시 방문할 필요가 없음
 * 3. Union-Find (Disjoint Set)를 사용하면 더 최적화 가능
 */
public class Baek_1976_여행가자 {
    static int N, M;
    static List<Integer>[] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine()); // 도시의 수
        M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

        map = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            map[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1)
                    map[i].add(j);
            }
        }

        int[] goal = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            goal[i] = Integer.parseInt(st.nextToken());
        }

        boolean canFin = true;

        // 지금 내 위치에서 다음 위치로 이동할 수 있는 지
        for(int i = 0; i < M - 1; i++){
            boolean[] visited = new boolean[N + 1];

            // 현재 위치 방문 표시
            visited[goal[i]] = true;

            // 다음 여행지랑 연결이 안 되어있으면 종료
            if(!dfs(goal[i], goal[i + 1], visited)){
                canFin = false;
                break;
            }
        }

        if(canFin)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
    // 현재 노드부터 목적지까지 갈 수 있는지를 반환하는 함수
    static boolean dfs(int cur, int des, boolean[] visited){
        // 지금 노드가 목적지면 종료
        if(cur == des) return true;

        visited[cur] = true;

        // 현재 노드와 연결되어 있는 여행지들
        for(int next : map[cur]){
            // 방문 안 했으면 방문
            if(!visited[next]){
                if(dfs(next, des, visited))
                    return true;
            }
        }
        
        // 연결되어 있는 모든 노드를 탐색했는데 발견하지 못하면 false 반환
        return false;
    }
}
