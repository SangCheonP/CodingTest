import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            // 현재 문자와의 중복이 없어질 때까지 왼쪽 경계 이동
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
