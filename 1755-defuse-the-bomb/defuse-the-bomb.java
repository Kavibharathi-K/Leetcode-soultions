class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k == 0) return new int[code.length];
        if(k > 0) return caseOne(code, k);
        return caseTwo(code, k);
    }   

    public int[] caseOne(int[] code, int k)
    {
        int sum = 0;

        for(int i = 0; i < k; i++)
            sum += code[i];

        int[] result = new int[code.length];
        for(int i = 0; i < code.length; i++)
        {
            sum -= code[i];
            sum += code[(i + k) % code.length];
            result[i] = sum;
        }
        return result;
    }
    public int[] caseTwo(int[] code, int k)
    {
        int[] array = reverse(code);
        int[] output = caseOne(array, -k);
        return reverse(output);
    }

    public int[] reverse(int[] nums)
    {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}