class Solution {
    public int maxBalancedShipments(int[] weight) {
        int currentMax = 0;
        int result = 0;

        for(int i = 0; i < weight.length; i++)
        {
            if(weight[i] >= currentMax) currentMax = weight[i];
            else{
                result++;
                currentMax = 0;
            }
        }
        return result; 
    }
}