class Solution {
    public int solution(String arr[]) {
        int n = (arr.length + 1) / 2;  // 숫자의 개수
        int[][] maxDP = new int[n][n]; // 최댓값 DP 테이블
        int[][] minDP = new int[n][n]; // 최솟값 DP 테이블
        int[] nums = new int[n];       // 숫자 배열
        char[] ops = new char[n - 1];  // 연산자 배열
        
        // 숫자와 연산자를 분리
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(arr[i * 2]); // 숫자 저장
            if(i < n - 1){
                ops[i] = arr[i * 2 + 1].charAt(0); // 연산자 저장
            }
        }
        
        // DP 배열 초기화 (대각선: 자기 자신)
        for (int i = 0; i < n; i++){
            maxDP[i][i] = nums[i];
            minDP[i][i] = nums[i];
        }
        
        // 길이 2 이상인 구간 처리
        for (int len = 1; len < n; len++){ // 부분 구간 길이 (1부터 n-1까지)
            for(int i = 0; i < n - len; i++){ // 시작 인덱스
                int j = i + len; // 끝 인덱스
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;
                
                // 연산자별로 구간을 나누어 계산
                for (int k = i; k < j; k++){
                    int max1 = maxDP[i][k]; // 왼쪽 구간 최댓값
                    int min1 = minDP[i][k]; // 왼쪽 구간 최솟값
                    int max2 = maxDP[k + 1][j]; // 오른쪽 구간 최댓값
                    int min2 = minDP[k + 1][j]; // 오른쪽 구간 최솟값
                    
                    if(ops[k] == '+'){
                        maxDP[i][j] = Math.max(maxDP[i][j], max1 + max2);
                        minDP[i][j] = Math.min(minDP[i][j], min1 + min2);
                    } else if (ops[k] == '-'){
                        maxDP[i][j] = Math.max(maxDP[i][j], max1 - min2);
                        minDP[i][j] = Math.min(minDP[i][j], min1 - max2);
                    }
                }
            }
        }
        
        return maxDP[0][n - 1];
    }
}
