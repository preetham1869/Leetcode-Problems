class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.MIN_VALUE;
        }
        for(int i=n-1;i>=0;i--){
            if(i+k>=n)arr[i]=energy[i];
            else arr[i]=arr[i+k]+energy[i];
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
}