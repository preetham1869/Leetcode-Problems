class Solution {
    public int minimumPairRemoval(int[] nums) {
      List<Integer> ls= new ArrayList<>();
        for (int n : nums) ls.add(n);
        int ops = 0;
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < ls.size() - 1; i++) {
                if (ls.get(i) > ls.get(i + 1)) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;
            int minS= Integer.MAX_VALUE;
            int idx= -1;
            for (int i = 0; i < ls.size() - 1; i++) {
                int sum=ls.get(i) + ls.get(i + 1);
                if (sum < minS) {
                    minS= sum;
                    idx= i;
                }
            }
            int merged=ls.get(idx) + ls.get(idx+ 1);
            ls.set(idx,merged);
            ls.remove(idx+ 1);
            ops++;
        }
        return ops;  
    }
}