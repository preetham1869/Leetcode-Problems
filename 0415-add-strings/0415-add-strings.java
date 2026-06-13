class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res=new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        while(i>=0||j>=0||carry>0){
            int a=0,b=0;
            if(i>=0)a=num1.charAt(i)-'0';
            if(j>=0)b=num2.charAt(j)-'0';
            int sum=a+b+carry;
            res.append(sum%10);
            carry=sum/10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}