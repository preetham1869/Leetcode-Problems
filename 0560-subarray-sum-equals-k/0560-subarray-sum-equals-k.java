class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer>sumMap = new HashMap<>();
        int sum=0;
        int cnt=0;
        sumMap.put(0,1);
        for(int num:nums){
            sum+=num;
          if(sumMap.containsKey(sum-k)){
             cnt+= sumMap.get(sum-k);
            }
             sumMap.put(sum,sumMap.getOrDefault(sum,0)+1);
        }
        return cnt;
    } 
}