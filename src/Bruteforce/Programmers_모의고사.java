import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        // 각 학생들의 정답 패턴 배열
        int[] s1 = {1, 2, 3, 4, 5}; 
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 

        // 학생들이 맞힌 정답 수를 저장할 변수
        int c1 = 0, c2 = 0, c3 = 0;

        // 정답을 비교하여 각 학생의 점수를 계산
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i % s1.length]) c1++;
            if (answers[i] == s2[i % s2.length]) c2++;
            if (answers[i] == s3[i % s3.length]) c3++;
        }

        // 최고 점수 계산
        int maxScore = Math.max(c1, Math.max(c2, c3));

        // 최고 점수를 받은 학생들을 리스트에 추가
        List<Integer> topScorers = new ArrayList<>();
        if (c1 == maxScore) topScorers.add(1);
        if (c2 == maxScore) topScorers.add(2);
        if (c3 == maxScore) topScorers.add(3);

        // 리스트를 배열로 변환하여 반환
        return topScorers.stream().mapToInt(i -> i).toArray();
    }
}
