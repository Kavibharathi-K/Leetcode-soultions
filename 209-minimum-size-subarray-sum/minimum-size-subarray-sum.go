func minSubArrayLen(target int, nums []int) int {
    result := len(nums) + 1
    left := 0
    currentTotal := 0

    for right := 0; right < len(nums); right++ {
        currentTotal += nums[right]

        for currentTotal >= target {
            result = min(result, right - left + 1)
            currentTotal -= nums[left];
            left++
        } 
    }
    if result == len(nums) + 1 {
        return 0
    }
    return result
}