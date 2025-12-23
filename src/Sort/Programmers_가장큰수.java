package Sort;

import java.util.*;

class Programmers_가장큰수 {
    public String solution(int[] numbers) {
        // 1. 주어진 수 스트링으로 변환
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 정렬: 두 숫자를 이어붙였을 때 더 큰 순서로 내림차순 정렬
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        
        // 3. 정렬 결과를 합쳐서 결과 문자열 생성
        String answer = String.join("", nums);
        
        // 4. "000..."인 경우를 처리 (모든 숫자가 0인 경우)
        if(answer.startsWith("0"))
            return "0";
        
        return answer;
    }
}
