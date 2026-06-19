class Solution {
    public int largestAltitude(int[] gain) {
        int curr=0;
        int maxi=0;
        for(int x:gain){
            curr+=x;
            maxi=Math.max(curr,maxi);
        }
        return maxi;
    }
}