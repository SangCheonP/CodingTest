package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
SWEA 1231 중위순회 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV140YnqAIECFAYD
 */
public class SWEA_1231 {
    // 트리 저장할 배열
    static String[] arr;
    
    // 중위 순회 재귀
    public static void recur(int idx){
        if(idx >= arr.length)
            return;
        recur(2*idx);
        System.out.print(arr[idx]);
        recur(2*idx + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int tc = 1; tc <= 10; tc++){
            // 1 ~ N
            int N = Integer.parseInt(br.readLine());
            String[] tmp;
            arr = new String[N + 1];

            // 트리를 배열에 저장
            for(int i = 1; i <= N; i++){
                tmp = br.readLine().split(" ");
                arr[i] = tmp[1];
            }

            System.out.print("#" + tc + " ");
            recur(1);
            System.out.println();
        }
    }
}
