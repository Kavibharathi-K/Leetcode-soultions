class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> list = new ArrayList();
        int sum = 0;

        while(n > 0)
        {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n /= 10;

            if(n <= 0)
            {
                if (sum == 1) return true;

                if(list.contains(sum)) return false;

                list.add(sum);
                n = sum;
                sum = 0;
            }
        }
    return false;
    }
}