class Solution {
    public int firstUniqChar(String s) {
        // 영어 소문자 26개의 등장 횟수를 저장
        int[] counts = new int[26];

        // 첫 번째 순회: 문자별 등장 횟수 집계
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }

        // 두 번째 순회: 앞부터 한 번만 등장하는 문자 확인
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counts[c - 'a'] == 1) {
                return i;
            }
        }

        // 한 번만 등장하는 문자가 없으면 -1 반환
        return -1;
    }
}
