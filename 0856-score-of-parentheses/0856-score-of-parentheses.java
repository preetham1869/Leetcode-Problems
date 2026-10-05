class Solution {
    public int scoreOfParentheses(String s) {
        int[] stack = new int[s.length()];
        int top = 0;
        for(char c : s.toCharArray()){
            if(c =='('){
                stack[++top] = 0;
            } 
            else{
                int curr = stack[top--];
                if (curr == 0)curr = 1;
                else curr=2*curr;
                stack[top]+=curr;
            }
        }
        return stack[0];
    }
}