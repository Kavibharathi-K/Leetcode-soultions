func containsNearbyDuplicate(nums []int, k int) bool {
    window := make(map[int]bool)

    for i, num := range nums {
        if window[num] {
            return true
        }

        window[num] = true

        if i >= k {
            delete(window, nums[i - k])
        }
    }
    return false
}