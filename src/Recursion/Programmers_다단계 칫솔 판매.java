/**
* 1. 등록자 - 추천인 의 Map 생성
* 2. 사람 - 이익의 Map 생성
* 3. seller을 돌면서 해당 amount의 돈을 Map을 통해 위까지 전달
* 4. center을 제외하고 enroll 순서대로 이익 배열을 리턴
**/

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 1. 등록자 - 추천인 Map 생성
        Map<String, String> members = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            members.put(enroll[i], referral[i]);
        }
        
        // 2. 사람 - 이익의 Map 생성 (순서 유지)
        Map<String, Integer> moneys = new LinkedHashMap<>();
        for (String name : enroll) {
            moneys.put(name, 0);
        }
        
        // 3. 판매자 수익 계산
        for (int i = 0; i < seller.length; i++) {
            calcMoney(members, moneys, seller[i], amount[i] * 100); // 칫솔 개당 100원
        }
        
        // 4. 결과 반환 (등록 순서대로)
        return moneys.values().stream().mapToInt(i -> i).toArray();
    }

    static void calcMoney(Map<String, String> members, Map<String, Integer> moneys, String name, int money) {
        if (name.equals("-") || money == 0) return; // 추천인이 없거나 커미션이 0원이면 종료

        int commission = money / 10; // 10% 커미션
        int remain = money - commission; // 현재 인물이 가져갈 금액

        moneys.put(name, moneys.get(name) + remain); // 현재 사람 수익 추가
        calcMoney(members, moneys, members.get(name), commission); // 추천인에게 전달
    }
}
