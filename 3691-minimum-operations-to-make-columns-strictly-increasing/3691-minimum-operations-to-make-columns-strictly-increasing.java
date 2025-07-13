class Solution {
    public int minimumOperations(int[][] grid) {
        int m=grid.length;/// no.of rows
        int n=grid[0].length;// no.of cols
        int op=0; 
        for(int j=0;j<n;j++){/// for columns........
            for(int i=1;i<m;i++){///for rows...
                if(grid[i][j]<=grid[i-1][j]){
                    int x=grid[i-1][j]+1-grid[i][j]; 
                    op+=x; 
                    grid[i][j]+=x;
                }
            }
          }
        return op; 
    }
}