package MST;
/*
백준 17472 다리 만들기 2(골드1)
https://www.acmicpc.net/problem/17472
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_17472_다리만들기2 {
    static int N, M, islandNum;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[] parent;
    static boolean[][] visited;
    static int[][] map, selected;
    static List<int[]> islandList, islandEdge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // map 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 부여하기 ( 1 ~ )
        islandNum = 1;
        visited = new boolean[N][M];
        // 섬의 좌표를 저장하는 리스트(i, j, islandNum)
        islandList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    dfs(i, j, islandNum);
                    islandNum += 1;
                }
            }
        }
        
        // 모든 섬의 좌표에 대해서 2개짜리 조합 생성
        selected = new int[2][2];
        // 섬을 연결하는 다리를 저장하는 리스트(섬1, 섬2, len)
        islandEdge = new ArrayList<>();
        makeComb(0, 0);

        // 다리 길이로 정렬
        Collections.sort(islandEdge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        makeSet();

        int edgeCnt = 0, result = 0;
        boolean canMake = false;
        for (int[] edge: islandEdge){
            // 같은 집합이면 넘김
            if(findRes(edge[0]) != findRes(edge[1])){
                union(edge[0], edge[1]);

                result += edge[2];
                edgeCnt += 1;
                //System.out.println("섬1: " + edge[0] + ", 섬2: " + edge[1] + ", len: " + edge[2]);

                // 다 골랐으면
                if (edgeCnt == islandNum - 2){
                    System.out.println(result);
                    canMake = true;
                    break;
                }
            };
        }
        // 모든 섬을 연결할 수 없으면
        if(!canMake)
            System.out.println(-1);
    }

    static void makeSet(){
        parent = new int[islandEdge.size() + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    static int findRes(int islandNum){
        if(parent[islandNum] == islandNum)
            return islandNum;
        return parent[islandNum] = findRes(parent[islandNum]);
    }

    static boolean union(int x, int y){
        int x_res = findRes(x);
        int y_res = findRes(y);
        if(x_res == y_res)
            return false;

        parent[y_res] = x_res;
        return true;
    }

    static void makeComb(int idx, int cnt){
        if(cnt == 2){
            //System.out.println("섬1 i: " + selected[0][0] + ", j: " + selected[0][1] + ", 섬2 i: " + selected[1][0] + ", j: " + selected[1][1]);
            // 섬의 번호가 다르면
            if(map[selected[0][0]][selected[0][1]] == map[selected[1][0]][selected[1][1]]){
                return;
            }

            // 직선만 가능
            if((selected[0][0] != selected[1][0]) && (selected[0][1] != selected[1][1])){
                return;
            }

            // 중간에 육지가 있으면 안 됨
            if(!checkEdge(selected[0], selected[1])){
                return;
            }

            // 길이가 2이상
            int islandLen = Math.abs(selected[0][0] - selected[1][0]) + Math.abs(selected[0][1] - selected[1][1]) - 1;
            if(islandLen <= 1){
                return;
            }

            // 해당 edge가 조건에 만족하면 리스트에 넣음
            islandEdge.add(new int[]{map[selected[0][0]][selected[0][1]], map[selected[1][0]][selected[1][1]], islandLen});

            return;
        }
        if(idx == islandList.size()){
            return;
        }

        // 해당 섬 선택
        selected[cnt][0] = islandList.get(idx)[0];
        selected[cnt][1] = islandList.get(idx)[1];
        makeComb(idx + 1, cnt + 1);
        makeComb(idx + 1, cnt);
    }

    static boolean checkEdge(int[] x, int[] y){
        // 같은 i
        if(x[0] == y[0]){
            int start = Math.min(x[1], y[1]);
            int goal = Math.max(x[1], y[1]);

            // 사이 다리
            for (int j = start+1; j <= goal-1; j++) {
                // 육지가 있으면
                if(map[x[0]][j] != 0)
                    return false;
            }
        // 같은 j
        }else{
            int start = Math.min(x[0], y[0]);
            int goal = Math.max(x[0], y[0]);

            for (int i = start+1; i <= goal-1; i++) {
                if(map[i][x[1]] != 0)
                    return false;
            }
        }

        return true;
    }

    static void dfs(int i, int j, int islandCnt){
        visited[i][j] = true;
        map[i][j] = islandCnt;
        
        islandList.add(new int[]{i, j, islandCnt});

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && map[ni][nj] == 1){
                dfs(ni, nj, islandCnt);
            }
        }

    }
}
