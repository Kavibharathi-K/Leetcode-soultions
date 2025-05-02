class Solution {
    public int reverse(int x) {
        int ans = 0;

        while(x != 0){

            if(ans > 214748364 || ans < -214748364){
            return 0;
            }   
            int rem = x % 10;
            ans = ans * 10 + rem;
            x /= 10;    
        }
        return  ans;
        
    }
}