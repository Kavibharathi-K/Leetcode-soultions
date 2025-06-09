func countGoodSubstrings(s string) int {
    count := 0
    window := make(map[byte]int)
    left := 0

    for right := 0; right < len(s); right++ {
        window[s[right]]++

        if right - left + 1 > 3 {
            window[s[left]]--

            if window[s[left]] == 0 {
                delete(window, s[left])
            }

            left++
        }

        if right - left + 1 == 3 && len(window) == 3 {
            count++
        }
    }
    return count
}