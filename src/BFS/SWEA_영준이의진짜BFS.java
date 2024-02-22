package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
SWEA No. 10 영준이의 진짜 BFS
https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AV5LnipaDvwDFAXc&categoryId=AY1INdsqPvADFAWX&categoryType=BATTLE&battleMainPageIndex=1
 */
public class SWEA_영준이의진짜BFS {
    static int N;
    static Queue<Integer> queue;
    static List<Integer>[] list;
    static int[] lenToRoot, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            // 1 ~ N번까지 노드 사용
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // 부모: 가진 자식 노드들 리스트
            list = new ArrayList[N + 1];
            parent = new int[N+1];

            // 루트까지 거리를 저장한 배열
            lenToRoot = new int[N+1];

            // 1번이 루트이기 때문에 거리 0 초기화
            lenToRoot[1] = 0;

            queue = new ArrayDeque<>();

            for (int i = 1; i < N+1; i++) {
                list[i] = new ArrayList<>();
            }

            // 2~N번 노드를 부모idx에 추가
            for (int node = 2; node < N+1; node++) {
                int p = Integer.parseInt(st.nextToken());
                // parent가 node를 가짐
                list[p].add(node);
                parent[node] = p;
            }

            // 정답
            int result = 0;

            //BFS
            queue.add(1);
            int size = 1, depth = 0, pre = 1;

            while(!queue.isEmpty()){
                size = queue.size();

                while (--size >= 0){
                    // 현재 정점
                    int cur = queue.poll();
                    // 현재 정점의 루트까지 거리 저장
                    lenToRoot[cur] = depth;

                    // 현재 정점을 부모로 자식 자식들을 큐에 넣음
                    for (Integer n: list[cur]){
                        queue.add(n);
                    }

                    result += calcLenFromLca(pre, cur);
                    pre = cur;
                }

                depth += 1;

            }

            System.out.println("#" + tc + " " + (result-2));
        }
    }

    static int calcLenFromLca(int a, int b){
        if(parent[a] == b)
            return 1;

        if(parent[a] == parent[b])
            return 2;

        int len = 0;
        // depth가 같아질 때까지
        while (lenToRoot[a] != lenToRoot[b]){
            if(lenToRoot[a] > lenToRoot[b])
                a = parent[a];
            else
                b = parent[b];
            len += 1;
        }

        // 최소 공통 조상을 만날 때까지
        while (a != b){
            a = parent[a];
            b = parent[b];
            len += 2;
        }

        return len;
    }
}