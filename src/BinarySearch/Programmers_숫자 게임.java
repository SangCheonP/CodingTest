import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // 1. A와 B 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int index = 0;  // B에서 사용할 인덱스
        int result = 0;

        // 2. A의 각 원소에 대해 이분 탐색 수행
        for (int i = 0; i < A.length; i++) {
            int left = index, right = B.length - 1;
            
            while (left <= right) {
                int mid = (left + right) / 2;
                
                if (B[mid] > A[i]) {
                    right = mid - 1; // 더 작은 값을 찾아야 함
                } else {
                    left = mid + 1; // 더 큰 값을 찾아야 함
                }
            }

            // B에서 A[i]보다 큰 값이 존재하는 경우
            if (left < B.length) {
                result++;
                index = left + 1;  // 다음 탐색을 위해 사용한 인덱스 업데이트
            }
        }

        return result;
    }
}
