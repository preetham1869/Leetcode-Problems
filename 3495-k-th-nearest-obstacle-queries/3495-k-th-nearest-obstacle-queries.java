class Solution {
    public int[] resultsArray(int[][] queries, int k) {
       PriorityQueue<Integer> numbers = new PriorityQueue<>( Collections.reverseOrder());
        int size = queries.length;
        int[] arr = new int[size];
        int j=0; 
        for(int i=0;i<queries.length;i++){
            int ans = Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            numbers.add(ans);
            if(numbers.size()>k)numbers.poll();
            if(numbers.size()==k)arr[j++]=numbers.peek();
            else arr[j++]=-1;
        }
        return arr;  
    }
}