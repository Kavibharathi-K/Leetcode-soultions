func numOfSubarrays(arr []int, k int, threshold int) int {
    left := 0
    count := 0
    currentTotal := 0

    for right := 0; right < len(arr); right++ {
        currentTotal = currentTotal + arr[right]

        if right - left + 1 > k {
            currentTotal = currentTotal - arr[left]
            left++
        }

        if right - left + 1 == k && currentTotal / k >= threshold {
            count++
        }

    }
    return count
}