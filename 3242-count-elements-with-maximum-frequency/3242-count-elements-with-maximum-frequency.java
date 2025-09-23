class Solution {
    public int maxFrequencyElements(int[] nums) {
       Map<Integer,Integer> mp=new HashMap<>();
       for(int num : nums){
        mp.put(num,mp.getOrDefault(num,0)+1);
       }
       int maxfq=0;
       for(int cnt:mp.values()) if(cnt>maxfq) maxfq=cnt;
       int res=0;
       for(int cnt:mp.values())if(cnt==maxfq)res+=cnt;
       return res;
    }
}