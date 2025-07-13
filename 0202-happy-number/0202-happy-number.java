class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while (n != 1 && !hs.contains(n)) {
            hs.add(n);
            n = getSumOfSquares(n);
        }
        return n==1;
    }
    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum +=num*num;
            n/=10;
        }
        return sum; 
    }
}