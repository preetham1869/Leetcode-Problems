class Solution {
    public boolean isBalanced(String num) {
      int evenS=0;
        int oddS=0;
        for(int i=0;i<num.length();i++){
            int number= num.charAt(i)-'0';
            if(i%2==0)evenS+=number;
            else oddS+=number;
            }
        return evenS==oddS;  
    }
}