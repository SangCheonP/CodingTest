class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        // DFS 진행
        makeNum(numbers, target, 0, 0);
        
        return answer;
    }
    
    static void makeNum(int[] numbers, int target, int idx, int sum){
        // 모든 숫자를 다 확인했으면
        if(idx == numbers.length){
            // 목표값이 만들어졌으면
            if(sum == target){
                answer++;
            }
            return;   
        }
        
        makeNum(numbers, target, idx + 1, sum + numbers[idx]);
        makeNum(numbers, target, idx + 1, sum - numbers[idx]);
    }
}
