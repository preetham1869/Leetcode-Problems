class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++)nums[i]=i+1;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            List<Integer> ans = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    ans.add(nums[j]);
                }
            }
            if(ans.size()==k)res.add(ans);
        }
        return res;
    }
}