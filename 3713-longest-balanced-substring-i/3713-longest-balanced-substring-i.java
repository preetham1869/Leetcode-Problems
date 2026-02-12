class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int maxi=0;
        for(int i=0;i<n;i++){
            int arr[]=new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'a']++;
                if(isB(arr))maxi=Math.max(maxi,j-i+1);
            }
        }
        return maxi;
    }
    private boolean isB(int arr[]){
        int cnt=0;
        for(int num:arr){
            if(num>0){
                if(cnt==0)cnt=num;
                else if(num!=cnt)return false;
            }
        }
        return true;
    }
}