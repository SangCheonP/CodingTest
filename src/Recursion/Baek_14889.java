package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
백준 14889 스타트와 링크 (실버 1)
https://www.acmicpc.net/problem/14889
 */
public class Baek_14889 {
    public static int N;
    public static int[][] map;
    public static List<Integer> start;
    public static List<Integer> link;
    public static boolean[] isSelected;

    public static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수
        // 4 <= N <= 20
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        isSelected = new boolean[N];
        
        // 능력치 입력 받음
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 1번 선수는 start 팀에 고정
        isSelected[0] = true;

        // 조합을 함
        comb(1, 1);

        System.out.println(result);
    }

    public static void comb(int idx, int trueCnt){
        // 선수가 반반으로 나뉘었을 때
        if(trueCnt == N/2){
            //System.out.println(Arrays.toString(isSelected));
            
            // 선수의 번호를 저장하는 리스트
            start = new ArrayList<>();
            link = new ArrayList<>();

            // 각 팀의 능력치의 합을 저장하는 변수
            int startSum = 0;
            int linkSum = 0;

            // start팀에 1번 선수 고정
            start.add(1);

            // true -> start / false -> link
            for(int i = 1; i < isSelected.length; i++){
                // true면 start
                if(isSelected[i]){
                    start.add(i+1);
                }else if(isSelected[i] == false){
                    link.add(i + 1);
                }
            }

            // 각 팀에 2명을 씩을 뽑아 해당 능력치들의 총합을 구함
            for(int i = 0; i < start.size(); i++){
                for(int j = i + 1; j < start.size(); j++){
                    startSum += map[start.get(i) - 1][start.get(j) - 1] + map[start.get(j) - 1][start.get(i) - 1];
                    linkSum += map[link.get(i) - 1][link.get(j)- 1] + map[link.get(j)- 1][link.get(i) - 1];
                }
            }

            // 차이
            int tmp = Math.abs(startSum - linkSum);

            // 더 작은 수를 구함
            result = result > tmp ? tmp : result;

            return;
        }

        // 선수가 반반으로 나뉘지 않았을 때는 그냥 반환
        if (idx == isSelected.length) {
            return;
        }

        // 해당 선수 선택O
        isSelected[idx] = true;
        comb(idx + 1, trueCnt + 1);

        // 해당 선수 선택X
        isSelected[idx] = false;
        comb(idx + 1, trueCnt);
    }
}
