class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt=new int[31];
        int mod=1000000007;
        for(int num:nums){
            for(int bit=0;bit<31;bit++){
                if((num&(1<<bit))!=0){
                    cnt[bit]++;
                }
            }
        }
        long ans=0;
        for(int i=0;i<k;i++){
            long num=0;
            for(int bit=0;bit<31;bit++){
                if(cnt[bit]>0){
                    num |= (1L<<bit);
                    cnt[bit]--;
                }
            }
            ans=(ans+num*num%mod)%mod;
        }
        return (int)ans;
    }
}