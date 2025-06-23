func maxProfit(prices []int) int {
    minimum := prices[0]
    profit := 0

    for _, num := range prices {
        profit = max(num - minimum, profit)
        minimum = min(num, minimum)
    }
    return profit
}