class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer>mp= new HashMap<>();
        for(int i=0;i<=nums.length-k;i++){
            HashMap<Integer,Boolean>vis= new HashMap<>();
            for(int j=i;j<i+k;j++){
                int num=nums[j];
                if(!vis.containsKey(num)){
                    vis.put(num,true);
                    mp.put(num,mp.getOrDefault(num,0)+1);
                }
            }
        }
        int ans= -1;
        for (int num : mp.keySet()) {
            if (mp.get(num) == 1) {
                ans= Math.max(ans, num);
            }
        }
        return ans;
    }
}