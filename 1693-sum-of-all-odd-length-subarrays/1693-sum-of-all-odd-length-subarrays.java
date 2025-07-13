class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
       int n= arr.length;
       int sum=0;
       int prefixSum[]=new int[n+1];
       for(int i=1;i<=n;i++){
        prefixSum[i] = prefixSum[i-1]+arr[i-1];
       }
       for(int i=0;i<n;i++){
        for(int j=1;i+j<=n;j+=2){
            int sum1 = prefixSum[i+j]-prefixSum[i];
            sum+=sum1;
        }
       }
       return sum;
    }
}