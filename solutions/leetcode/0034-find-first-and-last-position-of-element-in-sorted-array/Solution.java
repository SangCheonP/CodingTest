class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, first = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) first = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (first == -1) return new int[]{-1, -1};

        l = 0;
        r = nums.length - 1;
        int last = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) last = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{first, last};
    }
}
