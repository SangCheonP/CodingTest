package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N개의 스위치, 전구
 * 켜 or 꺼
 * i -> i-1, i, i+1
 * 켜 -> 꺼
 * 꺼 -> 켜
 *
 * 1 -> 1, 2
 * N -> N-1, N
 *
 * 주어진 목표 상태랑 똑같이 만들려면 최소 몇번?
 *
 * 2 <= N <= 100,000
 *
 * 0: 켜짐 / 1: 꺼짐
 *
 * 불가능 -> -1
 */

public class Baek_2138_전구와스위치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String tmp1 = br.readLine();
        String tmp2 = br.readLine();

        int[] cur1 = new int[N];
        int[] cur2 = new int[N];
        for(int i = 0; i < N; i++){
            cur1[i] = tmp1.charAt(i) - '0';
            cur2[i] = tmp1.charAt(i) - '0';
        }

        int[] goal = new int[N];
        for(int i = 0; i < N; i++){
            goal[i] = tmp2.charAt(i) - '0';
        }

        int result1 = 0;
        int result2 = 0;
        boolean canMake1 = false;
        boolean canMake2 = false;

        /**
         * 첫번째 스위치 누름
         * 두 번째 스위치부터 바로 왼쪽에 전구와 비교
         * 같으면 넘어감
         * 다르면 현재 스위치를 누름
         *
         * 첫번째 스위치 안 누름
         */

        // 첫번째 스위치 안 누름
        for(int i = 1; i < N; i++){
            if(goal[i - 1] == cur1[i - 1]) // 전 위치의 전구가 같으면 패스
                continue;

            changeLight(i, cur1);
            result1++;
        }

        // 끝까지 갔으면 목표랑 같은지 체크
        if(checkEqual(cur1, goal)){
            canMake1 = true;
        }

        // 첫번째 스위치 누름
        changeLight(0, cur2);
        result2 += 1;

        for(int i = 1; i < N; i++){
            if(goal[i - 1] == cur2[i - 1]) // 전 위치의 전구가 같으면 패스
                continue;

            changeLight(i, cur2);
            result2++;
        }

        // 끝까지 갔으면 목표랑 같은지 체크
        if(checkEqual(cur2, goal)){
            canMake2 = true;
        }

        if(canMake1 && canMake2)
            System.out.println(Math.min(result1, result2));
        else if(canMake1)
            System.out.println(result1);
        else if(canMake2)
            System.out.println(result2);
        else
            System.out.println(-1);
    }

    static boolean checkEqual(int[] cur, int[] goal){
        for(int i = 0; i < cur.length; i++){
            if(cur[i] != goal[i])
                return false;
        }
        return true;
    }

    // 해당 idx의 스위치를 눌러 전구를 바꿈
    static void changeLight(int idx, int[] light){
        if(idx == 0){ // 첫번째 스위치
            light[0] = change(light[0]);
            light[1] = change(light[1]);
        }else if(idx == light.length - 1){ // 마지막 스위치
            light[light.length - 2] = change(light[light.length - 2]);
            light[light.length - 1] = change(light[light.length - 1]);
        }else{
            light[idx - 1] = change(light[idx - 1]);
            light[idx] = change(light[idx]);
            light[idx + 1] = change(light[idx + 1]);
        }
    }

    static int change(int num){
        if(num == 0)
            return 1;
        else
            return 0;
    }
}
