class Solution {
    public int[] singleNumber(int[] nums) {
       Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums)mp.put(num, mp.getOrDefault(num,0) + 1);
        int[] ans = new int[2];
        int idx = 0;
        for(int key : mp.keySet()){
            if(mp.get(key) == 1){
                ans[idx++] = key;
            }
        }
        return ans; 
    }
}