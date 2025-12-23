package BackTracking;
/**
* 1. 각 불량 사용자 패턴별로 가능한 응모자 리스트를 저장
* 2. 백트래킹(DFS)를 이용해 모든 조합을 생성
*    - 중복된 조합을 방지하기 위해 Set을 사용
*    - 동일한 응모자가 중복 선택되지 않도록 관리
**/

import java.util.*;

class Programmers_불량사용자 {
    // 유효한 조합을 저장하는 Set (중복 제거를 위해 Set 사용)
    static Set<Set<String>> validCombinations = new HashSet<>();
    
    // 각 불량 사용자 패턴에 매칭되는 유저 목록을 저장하는 리스트
    static List<List<String>> possibleLists = new ArrayList<>();

    public static int solution(String[] user_id, String[] banned_id) {
        // 초기화
        possibleLists.clear();
        validCombinations.clear();

        // 1. 각 불량 사용자 패턴에 대해 가능한 응모자 찾기
        for (String ban : banned_id) {
            List<String> matchedUsers = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(user, ban)) { // 패턴과 일치하는 유저인지 검사
                    matchedUsers.add(user);
                }
            }
            possibleLists.add(matchedUsers); // 매칭된 유저 리스트 저장
        }

        // 2. 백트래킹을 이용해 가능한 모든 조합 찾기
        findCombinations(new HashSet<>(), 0);

        // 3. 저장된 유효한 조합 개수 반환
        return validCombinations.size();
    }

    // 특정 user가 불량 사용자 패턴 ban과 매칭되는지 확인하는 함수
    private static boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) return false; // 길이가 다르면 매칭 불가
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) {
                return false; // '*'가 아닌 문자에서 차이가 발생하면 불일치
            }
        }
        return true; // 모든 조건을 통과하면 매칭 성공
    }

    // 가능한 모든 조합을 찾는 백트래킹 함수
    private static void findCombinations(Set<String> currentSet, int index) {
        // 종료 조건: 모든 불량 사용자 패턴에 대해 선택이 완료되었을 때
        if (index == possibleLists.size()) {
            validCombinations.add(new HashSet<>(currentSet)); // 중복을 방지하기 위해 Set에 저장
            return;
        }

        // 현재 불량 사용자 패턴에 해당하는 가능한 유저들 탐색
        for (String user : possibleLists.get(index)) {
            if (!currentSet.contains(user)) { // 이미 선택된 유저는 다시 선택할 수 없음
                currentSet.add(user);
                findCombinations(currentSet, index + 1); // 다음 단계로 이동
                currentSet.remove(user); // 백트래킹 (되돌리기)
            }
        }
    }
}
