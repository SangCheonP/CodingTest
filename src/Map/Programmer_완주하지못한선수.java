import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. 참가자 목록을 Map에 저장하면서 이름별 카운트 증가
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. 완주한 사람들을 Map에서 처리하며 카운트 감소
        for (String c : completion) {
            if (map.get(c) == 1) {
                map.remove(c); // 카운트가 1이면 삭제
            } else {
                map.put(c, map.get(c) - 1); // 카운트 감소
            }
        }
        
        // 3. Map에 남아있는 하나의 이름을 반환
        for (String key : map.keySet()) {
            answer = key; // 남아있는 이름이 정답
        }
        
        return answer;
    }
}
