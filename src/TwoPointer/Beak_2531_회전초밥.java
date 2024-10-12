package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak_2531_회전초밥 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0; // 제거할 요소, 추가할 요소

        int result = 0;
        int curKinds = 0;

        // 처음 k개의 접시를 윈도우에 추가
        for (int i = 0; i < k; i++) {
            int kind = sushi[right];

            // 해당 종류의 초밥이 이미 있으면
            if(map.containsKey(kind)){
                map.put(kind, map.get(kind) + 1);
            }else{ // 없으면
                map.put(kind, 1);
                curKinds += 1;
            }

            right = (right + 1) % N;
            System.out.println("left: " + left + " right: " + right + " len: " + (right - left));
        }

        // 쿠폰 초밥을 고려하여 최대 종류 계산
        result = map.containsKey(c) ? curKinds : curKinds + 1;

        // 슬라이딩 윈도우를 이용하여 최대 종류 계산
        while(left < N){
            System.out.println("left: " + left + " right: " + right + " len: " + (right - left));
            // 왼쪽 초밥 제거
            int leftSushi = sushi[left];
            if(map.get(leftSushi) == 1){
                map.remove(leftSushi);
                curKinds -= 1;
            }else{
                map.put(leftSushi, map.get(leftSushi) - 1);
            }

            // 오른쪽 초밥 추가
            int rightSushi = sushi[right];
            if(map.containsKey(rightSushi)){
                map.put(rightSushi, map.get(rightSushi) + 1);
            }else{
                map.put(rightSushi, 1);
                curKinds += 1;
            }

            // 쿠폰 초밥을 고려하여 최대 종류 계산
            int tempResult = map.containsKey(c) ? curKinds : curKinds + 1;
            result = Math.max(result, tempResult);

            // 포인터 이동
            left += 1;
            right = (right + 1) % N;
            System.out.println("left: " + left + " right: " + right + " len: " + (right - left));
            System.out.println("-----------------------------------------");
        }

        System.out.println(result);
    }
}
