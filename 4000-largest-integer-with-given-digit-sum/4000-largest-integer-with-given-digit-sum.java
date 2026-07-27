class Solution {
    public int largestInteger(int n, int s) {
        if(s<0 || s>9*n)return -1;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int num=9;num>=0;num--){
                int rem=s-num;
                int pos=n-i-1;
                if(rem>=0 && rem<=pos*9){
                    ans.append(num);
                    s=rem;
                    break;
                }
            }
        }
        return Integer.parseInt(ans.toString());
    }
}