class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
       int maxArea=0;
       int diagonal=0;
       for(int[] rec:dimensions){
        int l=rec[0];
        int w=rec[1];
        int dsq=l*l+w*w;
        int area=l*w;
        if(dsq>diagonal ||(diagonal == dsq && area > maxArea)){
            diagonal= dsq;
            maxArea=area;
        }
       }
       return maxArea;
    }
}