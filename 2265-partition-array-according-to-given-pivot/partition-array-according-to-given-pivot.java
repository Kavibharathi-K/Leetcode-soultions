class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int p1 = 0;
        int p2 = nums.length - 1;

        while (left < nums.length && right >= 0) {
            if (nums[left] < pivot) {
                result[p1++] = nums[left];
            }
            if (nums[right] > pivot) {
                result[p2--] = nums[right];
            }
            left++;
            right--;
        }

        int remaining = p2 - p1 + 1;
        while (remaining > 0) {
            result[p1++] = pivot;
            remaining--;
        }
        return result;
    }
}