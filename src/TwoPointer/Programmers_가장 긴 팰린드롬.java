class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // 홀수 길이 팰린드롬 체크
            answer = Math.max(answer, checkPal1(s, i, n));
            // 짝수 길이 팰린드롬 체크
            answer = Math.max(answer, checkPal2(s, i, n));
        }

        return answer;
    }

    static int checkPal1(String s, int idx, int n) {
        int len = 1;

        for (int i = 1; idx - i >= 0 && idx + i < n; i++) {
            if (s.charAt(idx - i) != s.charAt(idx + i)) break;
            len += 2;
        }

        return len;
    }

    static int checkPal2(String s, int idx, int n) {
        int left = idx, right = idx + 1;

        if (right >= n || s.charAt(left) != s.charAt(right)) return 0; // 첫 두 문자 다르면 길이 0

        int len = 2;

        for (int i = 1; left - i >= 0 && right + i < n; i++) {
            if (s.charAt(left - i) != s.charAt(right + i)) break;
            len += 2;
        }

        return len;
    }
}
