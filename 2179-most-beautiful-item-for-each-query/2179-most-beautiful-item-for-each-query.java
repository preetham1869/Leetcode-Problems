class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
         Arrays.sort(items,(a,b) -> Integer.compare(b[1],a[1]));
        List<Integer> res = new ArrayList<>();
        for(int query:queries){
            boolean found = false;
            for(int[] item:items){
                if(item[0]<=query){
                    res.add(item[1]);
                    found = true;
                    break;
                }
            }
            if(!found)res.add(0);
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++)ans[i] = res.get(i);
        return ans;
    }
}