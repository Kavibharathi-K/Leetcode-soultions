func characterReplacement(str string, k int) int {
    set := make(map[byte]int)
	left := 0
	right := 0
	currentMaxChar := 0
	result := 0

	for right < len(str) {
		set[str[right]]++

		if set[str[currentMaxChar]] < set[str[right]] {
			currentMaxChar = right
		}

		if (right - left + 1) - set[str[currentMaxChar]] > k {
			set[str[left]]--
			left++
		}

		result = max(result, right - left + 1)
        right++
	}
    return result
}