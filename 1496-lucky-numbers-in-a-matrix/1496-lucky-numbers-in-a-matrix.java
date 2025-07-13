class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
         int m = matrix.length;
        int n = matrix[0].length;

        int[] arr= new int[n];
        Arrays.fill(arr,Integer.MIN_VALUE);
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                arr[j] = Math.max(arr[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            int rowMin = Integer.MAX_VALUE;
            int idx=-1;
            for(int j=0;j<n;j++){
                if(matrix[i][j]<rowMin){
                    rowMin=matrix[i][j];
                    idx=j;
                }
            }
            if(rowMin==arr[idx])res.add(rowMin);
        }
        return res;
    }
}