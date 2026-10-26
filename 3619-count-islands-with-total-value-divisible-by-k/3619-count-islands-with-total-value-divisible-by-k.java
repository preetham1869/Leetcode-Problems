class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length,cnt=0;
        int[] d={-1,0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0)continue;
                long sum = 0;
                Stack<int[]> st = new Stack<>();
                st.push(new int[]{i,j});
                sum += grid[i][j];
                grid[i][j] = 0;
                while(!st.isEmpty()){
                    int[] p=st.pop();
                    for(int x=0;x<4;x++){
                        int r=p[0]+d[x],c = p[1]+d[x+1];
                        if(r>=0 && r<m && c>=0 && c<n && grid[r][c]>0){
                            sum += grid[r][c];
                            st.push(new int[]{r,c});
                            grid[r][c] = 0;
                        }
                    }
                }
                if(sum%k==0)cnt++;
            }
        }
        return cnt;
    }
}