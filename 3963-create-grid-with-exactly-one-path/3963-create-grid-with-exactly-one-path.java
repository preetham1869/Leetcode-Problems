class Solution {
    public String[] createGrid(int m, int n) {
       char[][] arr=new char[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(arr[i],'#');
        }
        for(int j=0;j<n;j++){
            arr[0][j]='.';
        }
        for(int i=0;i<m;i++){
            arr[i][n-1]='.';
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            ans.add(new String(arr[i]));
        }
        return ans.toArray(new String[0]);
    }
}