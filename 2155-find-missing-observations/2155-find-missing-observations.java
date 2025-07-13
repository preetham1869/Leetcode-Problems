class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
         int sum = 0;
        for(int i : rolls)sum+=i;
        int nSum = (mean*(n+rolls.length))-sum;
        if(nSum<n||nSum>6*n){
            int[] empty = {};
            return empty;
        }
        else{
            int[] ans = new int[n];
            int start = nSum/n;
            for(int i=0;i<n;i++){
                ans[i]=start;
            }
            int left=nSum-(start*n);
            for(int i=0;i<left;i++){
            ans[i]=ans[i]+1;
            }
            return ans;
        }
    }
}