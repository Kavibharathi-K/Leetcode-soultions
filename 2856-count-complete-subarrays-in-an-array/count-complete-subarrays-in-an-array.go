func countCompleteSubarrays(array []int) int {
    set := make(map[int]bool)

	for _,num := range array {
		set[num] = true
	}
	k := len(set)

	left := 0
	result := 0
	currentWindow := make(map[int]int)

	for right := 0; right < len(array); right++ {
		currentWindow[array[right]]++

		for len(currentWindow) == k {
			result += len(array) - right
			
            currentWindow[array[left]]--

            if currentWindow[array[left]] == 0 {
			    delete(currentWindow, array[left])
            }
            left++
		}
	}
    return result
}