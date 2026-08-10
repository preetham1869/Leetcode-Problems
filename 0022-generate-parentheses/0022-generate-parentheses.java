class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        GenerateParenthesis("",0,0,n);
        return ans;
    }
    void GenerateParenthesis(String s,int open,int close,int n){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        if(open<n){
            GenerateParenthesis(s+"(",open+1,close,n);
        }
        if(close<open){
            GenerateParenthesis(s+")",open,close+1,n);
        }
    }
}