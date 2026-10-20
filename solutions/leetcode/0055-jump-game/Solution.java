class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            // 현재 위치에 도달할 수 없으면 이후 위치도 갈 수 없음
            if (i > farthest) {
                return false;
            }

            // 도달 가능한 현재 위치에서 이동 범위를 확장
            farthest = Math.max(farthest, i + nums[i]);

            // 마지막 위치까지 도달 가능
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
