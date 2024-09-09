package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_20437_문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < TC; tc++) {
            char[] W = br.readLine().toCharArray();
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            boolean canMin = false;
            boolean canMax = false;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // a: 0
            // b: 1
            // ...
            // z: 25
            // 모든 알파벳 배열 선언
            List<Integer>[] arr = new ArrayList[26];

            for (int i = 0; i < 26; i++) {
                arr[i] = new ArrayList<>();
            }
            
            // 해당 알파벳의 위치 저장
            for(int i = 0; i < W.length; i++){
                arr[(W[i] - 'a')].add(i);
            }
            //System.out.println("K: " + K);

            // 각 알파벳이 K번 이상 등장하는지 확인
            for (int i = 0; i < arr.length; i++) {
                //System.out.println("i: " + i + ", size: " + arr[i].size());
                
                // K보다 길이 짧은 것은 제외
                if(arr[i].size() < K)
                    continue;

                // 해당 알파벳의 등장 위치 중 K번 연속된 부분 문자열 길이 계산
                for (int j = 0; j < arr[i].size() - K + 1; j++) {
                    // 부분 문자열의 길이
                    int tmp = arr[i].get(j + K - 1) - arr[i].get(j) + 1;
                    
                    //System.out.println("j: " + j + ", " + (j + K - 1) + ", " + tmp);
                    
                    // 가장 짧은 길이 저장
                    if (min > tmp) {
                        min = tmp;
                        canMin = true;
                    }

                    // 가장 긴 길이 저장
                    if (max < tmp) {
                        max = tmp;
                        canMax = true;
                    }
                }
            }

            if(canMin && canMax){
                System.out.println(min + " " + max);
            }else{
                System.out.println(-1);
            }
        }
    }
}
