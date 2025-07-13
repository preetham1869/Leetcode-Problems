class Solution {
    int getSum(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num=num/10;
        }
        return ans;
    }
    public int getLucky(String s, int k) {
        int ans=0;
        for(char ch : s.toCharArray()){
            ans+=getSum(ch-96);
        }
        for(int i=1;i<k;i++){
            ans=getSum(ans);
        }
        return ans;
    }
}