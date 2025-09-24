class Solution {
    public int countDigits(int num) {
        int cnt=0;
        int copy=num;
        while(num>0){
            int d=num%10;
            num/=10;
        if(d!=0 && copy%d==0)cnt++;
        }
        return cnt;
    }
}