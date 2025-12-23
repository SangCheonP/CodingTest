package DP;

import java.util.*;

class Programmers_N으로표현 {
    public int solution(int N, int number) {
        if(N == number){
            return 1;
        }
        
        // N을 1번 ~ 8번 사용한 경우의 결과를 저장할 DP 리스트
        List<Set<Integer>> dp = new LinkedList<>();
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        // N을 i번 연속 사용한 숫자를 초기화
        for(int i = 1; i <= 8; i++){
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        // N을 1번 ~ 8번 사용하는 경우를 계산
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j < i; j++){
                for(int x : dp.get(j)){
                    for(int y : dp.get(i - j)){
                        dp.get(i).add(x + y);
                        dp.get(i).add(x - y);
                        dp.get(i).add(x * y);
                        if(y != 0){
                            dp.get(i).add(x/y);
                        }
                    }
                }
            }

            // 목표 숫자가 존재하면 i 반환
            if(dp.get(i).contains(number)){
                return i;   
            }
        }

        // 8번 안에 목표 숫자를 만들지 못하면 -1 반환
        return -1;
    }
}
