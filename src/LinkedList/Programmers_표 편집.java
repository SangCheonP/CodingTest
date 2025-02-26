import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];

        // **연결 리스트 초기화**
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // 이전 노드 설정
            next[i] = i + 1; // 다음 노드 설정
        }
        next[n - 1] = -1; // 마지막 노드는 다음이 없음

        for (String c : cmd) {
            String[] tmp = c.split(" ");
            if (tmp[0].equals("U")) {
                int x = Integer.parseInt(tmp[1]);
                while (x-- > 0) k = prev[k]; // 위로 이동
            } 
            else if (tmp[0].equals("D")) {
                int x = Integer.parseInt(tmp[1]);
                while (x-- > 0) k = next[k]; // 아래로 이동
            } 
            else if (tmp[0].equals("C")) {
                deleted.push(k); // 삭제된 인덱스를 스택에 저장 (복구를 위해)

                if (prev[k] != -1) next[prev[k]] = next[k]; // 현재(k)의 이전 노드가 있다면, 이전 노드의 next를 현재의 next로 연결
                if (next[k] != -1) prev[next[k]] = prev[k]; // 현재(k)의 다음 노드가 있다면, 다음 노드의 prev를 현재의 prev로 연결

                k = (next[k] != -1) ? next[k] : prev[k]; // 삭제 후 다음 선택: 다음 노드가 있으면 그쪽으로 이동, 없으면 이전 노드로 이동
            }
            else if (tmp[0].equals("Z")) {
                int restore = deleted.pop(); // 최근 삭제된 행을 복구

                if (prev[restore] != -1) next[prev[restore]] = restore; // 이전 노드가 있다면, next를 현재 노드(restore)로 복구
                if (next[restore] != -1) prev[next[restore]] = restore; // 다음 노드가 있다면, prev를 현재 노드(restore)로 복구
            }
        }

        // **최종 결과 문자열 생성**
        StringBuilder sb = new StringBuilder("O".repeat(n));
        while (!deleted.isEmpty()) sb.setCharAt(deleted.pop(), 'X');

        return sb.toString();
    }
}
