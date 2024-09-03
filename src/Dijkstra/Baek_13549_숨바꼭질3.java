package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_13549_숨바꼭질3 {
    static int INF = Integer.MAX_VALUE;
    static int[] map = new int[100001];

    static class Node implements Comparable<Node> {
        int n, w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return this.w-o.w;
        }
    }

    static int dijkstra(int N, int K){
        Arrays.fill(map, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));
        map[N] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            // 목적지에 도착하면
            if(cur.n == K)
                break;

            // 갱신된 가중치가 현재 가중치보다 낮으면 패스
            if(map[cur.n] < cur.w){
                continue;
            }

            // 기존의 거리가 더 짧으면
            int np1 = cur.n + 1;
            if(isVaild(np1) && map[np1] > cur.w + 1){
                map[np1] = cur.w+1;
                pq.offer(new Node(np1, map[np1]));
            }

            int np2 = cur.n - 1;
            if(isVaild(np2) && map[np2] > cur.w + 1){
                map[np2] = cur.w+1;
                pq.offer(new Node(np2, map[np2]));
            }

            int np3 = cur.n * 2;
            if(isVaild(np3) && map[np3] > cur.w){
                map[np3] = cur.w;
                pq.offer(new Node(np3, map[np3]));
            }
        }

        return map[K];
    }

    static boolean isVaild(int num){
        if(0 <= num && num <= 100000)
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 수빈
        // K: 동생
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N >= K){
            System.out.println(N - K);
        }else{
            System.out.println(dijkstra(N, K));
        }
    }
}
