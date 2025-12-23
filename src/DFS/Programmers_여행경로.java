package DFS;

import java.util.*;

class Programmers_여행경로 {
    static List<String> result;
    static Map<String, PriorityQueue<String>> map;
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        result = new ArrayList<>();

        // 티켓 정보를 맵에 저장
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        // DFS 실행
        dfs("ICN");

        // 결과를 리스트에서 배열로 변환
        Collections.reverse(result);
        return result.toArray(new String[0]);
    }

    static void dfs(String airport) {
        // 현재 공항에서 출발할 수 있는 모든 공항 방문
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            dfs(map.get(airport).poll());
        }
        result.add(airport);
    }
}
