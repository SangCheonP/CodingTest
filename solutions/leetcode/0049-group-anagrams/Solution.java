import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 문자 배열을 정렬해 같은 애너그램의 공통 키 생성
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sorted = new String(cs);

            // 그룹이 없으면 생성하고 원래 문자열을 추가
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        // 각 그룹의 목록을 결과로 반환
        return new ArrayList<>(map.values());
    }
}
