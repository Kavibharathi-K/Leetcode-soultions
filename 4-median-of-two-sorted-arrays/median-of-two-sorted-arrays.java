class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int len = nums1.length + nums2.length;
        double arr[] = new double[len];int i; 
        double res;
        for(i = 0; i < nums1.length; i++)
        arr[i] = nums1[i];
        for(int j = 0; j < nums2.length; j++)
        arr[i + j] = nums2[j];
        int index = len / 2;
        Arrays.sort(arr);
        if(len % 2 == 1)
        res = arr[index];
        else
        res = (arr[index] + arr[index - 1])/2;
        return res;
    }
}