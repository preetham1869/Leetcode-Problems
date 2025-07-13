class Solution {
    public int[] minOperations(String boxes){
        int n=boxes.length();
        List<Integer> idx = new ArrayList<>();
        for(int i=0;i<n; i++){
            if(boxes.charAt(i)=='1'){
                idx.add(i);
            }
        }
        int[] op= new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<idx.size();j++){
                sum+=Math.abs(i-idx.get(j));
            }
            op[i]=sum;
        }
        return op;
    }
}
// Given a string ,we have to calculate min no of operations to fill boxes[i]