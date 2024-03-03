import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
크루스칼
MST 간선 중심
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
 */
public class KruscalPratice {
    static int V, E;
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int str, ed, w;
        Edge(int str, int ed, int w){
            this.str = str;
            this.ed = ed;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "str=" + str +
                    ", ed=" + ed +
                    ", w=" + w +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // V: 정점의 개수 / E: 간선의 개수
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 간선 리스트
        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int str = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(str, ed, w));
        }

        // 가중치 순으로 정렬
        Collections.sort(edgeList);

        // 자기 자신을 부모로 설정
        makeSet();

        // 추가한 간선의 수, MST 값
        int cnt = 0, result = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            // 대표가 같으면 패스
            if(findRes(edgeList.get(i).str) == findRes(edgeList.get(i).ed)){
                continue;
            }

            // 두 트리를 합침
            union(edgeList.get(i).str, edgeList.get(i).ed);
            result += edgeList.get(i).w;

            // 정점의 개수 - 1를 봤으면
            if(++cnt == V-1){
                break;
            }
        }

        System.out.println(cnt == V-1 ? result : -1);

    }

    static void makeSet(){
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    static int findRes(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = findRes(parent[x]);
    }

    static boolean union(int x, int y){
        int x_res = findRes(x);
        int y_res = findRes(y);

        if(x_res == y_res)
            return false;

        parent[y_res] = x_res;

        return true;
    }
}

