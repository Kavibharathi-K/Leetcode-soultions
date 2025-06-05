func numberOfSubstrings(str string) int {
	count := [3]int{}
	left := 0
	result := 0

	for right := 0; right < len(str); right++ {

		count[str[right]-'a']++

		for count[0] > 0 && count[1] > 0 && count[2] > 0 {
			result += len(str) - right

			count[str[left]-'a']--
			left++
		}
	}

	return result
}