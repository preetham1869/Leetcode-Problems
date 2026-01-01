class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt=0,oddC=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        for(int num:nums){
            if(num%2!=0)oddC++;
            if(mp.containsKey(oddC-k)){
                cnt+=mp.get(oddC-k);
            }
            mp.put(oddC,mp.getOrDefault(oddC,0)+1);
        }
        return cnt;
    }
}