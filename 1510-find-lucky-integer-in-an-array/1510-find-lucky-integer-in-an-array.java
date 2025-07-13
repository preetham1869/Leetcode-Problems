class Solution {
    public int findLucky(int[] arr) {
        int[] frq=new int[501];
        int ans=-1;
        for(int num:arr)frq[num]++;
        for(int i=1;i<frq.length;i++){
            if(frq[i]==i)ans=i;
        }
        return ans;
    }
}