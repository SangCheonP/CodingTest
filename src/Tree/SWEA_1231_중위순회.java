package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
SWEA No. 7 [S/W 문제해결 기본] 9일차 - 중위순회 - DFS, BST
https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AV140YnqAIECFAYD&categoryId=AY1INdsqPvADFAWX&categoryType=BATTLE&battleMainPageIndex=1
 */
public class SWEA_1231_중위순회 {
    public static int N;
    public static char[] cs;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());

            // data 배열
            cs = new char[N+1];

            sb = new StringBuilder();

            for (int i = 1; i <= N; i++) {
                // data만 자름
                cs[i] = br.readLine().split(" ")[1].charAt(0);
            }

            dfs(1);

            System.out.println("#"+tc + " " + sb.toString());
        }
    }

    public static void dfs(int idx){
        if(idx > N)
            return;

        // 중위 순회
        dfs(idx*2);
        sb.append(cs[idx]);
        dfs(idx*2+1);
    }
}
