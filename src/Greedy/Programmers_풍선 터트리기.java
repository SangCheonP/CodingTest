class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length];   // 왼쪽 최소값 배열
        int[] rightMin = new int[a.length];  // 오른쪽 최소값 배열

        // 1️⃣ 왼쪽에서 최소값 찾기
        int min = a[0];  // 가장 처음 값이 초기 최소값
        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);  // 현재까지의 최소값 갱신
            leftMin[i] = min;  // 최소값 저장
        }

        // 2️⃣ 오른쪽에서 최소값 찾기
        min = a[a.length - 1];  // 마지막 값이 초기 최소값
        for (int i = a.length - 1; i >= 0; i--) {
            min = Math.min(min, a[i]);  // 현재까지의 최소값 갱신
            rightMin[i] = min;  // 최소값 저장
        }

        // 3️⃣ 살아남을 수 있는 풍선 개수 세기
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {  // 왼쪽 or 오른쪽 최소값이면 살아남음
                result++;
            }
        }

        return result;
    }
}
