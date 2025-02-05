import java.util.*;

class Solution {
    // 단어와 변환 횟수를 저장하는 Word 클래스
    static class Word {
        String w;
        int c;
        
        Word(String w, int c) {
            this.w = w; // 변환된 단어
            this.c = c; // 변환 횟수
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>(); // BFS를 위한 큐 생성
        Set<String> visited = new HashSet<>(); // 방문한 단어 저장
        
        queue.offer(new Word(begin, 0)); // 시작 단어 삽입
        visited.add(begin); // 시작 단어 방문 처리
        
        while (!queue.isEmpty()) {
            Word cur = queue.poll(); // 큐에서 현재 단어 가져오기
            String s = cur.w;
            int cnt = cur.c;
            
            if (s.equals(target)) { // 목표 단어에 도달하면 변환 횟수 반환
                return cnt;
            }
            
            for (String t : findWords(s, words, visited)) { // 변환 가능한 단어 탐색
                queue.offer(new Word(t, cnt + 1)); // 변환된 단어와 횟수 저장
                visited.add(t); // 방문 처리
            }
        }
        
        return 0; // 변환할 수 없는 경우
    }
    
    // 현재 단어와 한 글자만 다른 단어 리스트 반환
    static List<String> findWords(String cur, String[] words, Set<String> visited) {
        List<String> list = new ArrayList<>();
        
        for (String word : words) {
            if (!visited.contains(word) && isOneLetterDifferent(cur, word)) {
                list.add(word); // 한 글자만 다른 단어 추가
            }
        }
        
        return list;
    }
    
    // 두 단어가 한 글자만 다른지 확인하는 메서드
    static boolean isOneLetterDifferent(String a, String b) {
        int diff = 0; // 다른 글자 개수 카운트
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false; // 두 글자 이상 다르면 false
            }
        }
        return diff == 1; // 정확히 한 글자만 다를 때 true 반환
    }
}
