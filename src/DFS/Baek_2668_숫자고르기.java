package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baek_2668_숫자고르기 {
    static int N;
    static int[] nums;
    static boolean[] visited;
    static boolean[] selected;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수 입력 받기
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        // 정렬
        Collections.sort(result);

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void dfs(int start, int target){
        // 방문하지 않았으면 다음 수 진행
        if(!visited[nums[start]]){
            visited[nums[start]] = true;
            dfs(nums[start], target);
            visited[nums[start]] = false;
        }

        // 사이클이 만들어지면 시작 수 추가
        if(nums[start] == target) result.add(target);
    }
}
