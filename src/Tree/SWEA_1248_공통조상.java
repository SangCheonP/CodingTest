package Tree;
/*
SWEA No. 8 [S/W 문제해결 응용] 3일차 - 공통조상
https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD&categoryId=AY1INdsqPvADFAWX&categoryType=BATTLE&battleMainPageIndex=1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1248_공통조상 {
    public static int TC, V, E, n1, n2;
    public static int[] ancestor, subCnt;
    public static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            
            // V: 노드의 개수 / E: 간선의 개수 / n1, n2: 공통 조상을 찾는 두 노드 번호
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            // 해당 노드의 부모를 관리하는 배열 1 ~ V 사용
            ancestor = new int[V+1];

            // 해당 노드 서브트리 개수 배열 1 ~ V 사용
            subCnt = new int[V+1];

            set = new TreeSet<>();

            for (int i = 1; i < V+1; i++) {
                subCnt[i] = 1;
            }

            st = new StringTokenizer(br.readLine());
            for (int v = 0; v < E; v++) {
                // p: 부모 노드 / c: 자식 노드
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                // c의 부모는 p
                ancestor[c] = p;
            }

            // 서브트리개수 계산
            clacSubCnt(1);

            // n1에 대한 조상 체크
            checkAncestor(n1);
            System.out.print("#" + tc + " " );
            // n2에 대한 조상 체크
            checkAncestor(n2);


        }
    }

    public static int clacSubCnt(int idx){
        boolean hasChild = false;
        for (int v = 1; v < V+1 ; v++) {
            // v의 조상이 idx면
            if(ancestor[v] == idx){
                subCnt[idx] += clacSubCnt(v);
                hasChild = true;
            }
        }

        // 자식을 가지고 있으면
        if(hasChild)
            return subCnt[idx];
        
        return 1;
    }

    public static void checkAncestor(int idx){
        if(idx == 1)
            return;
        
        // p = idx의 조상
        int p = ancestor[idx];
        
        // 공통 조상 발견시
        if(set.contains(p)){
            System.out.println(p + " " + subCnt[p]);
            return;
        }
        
        // 조상 추가
        set.add(p);
        // 더 상위 조상 찾아봄
        checkAncestor(p);
    }

}
