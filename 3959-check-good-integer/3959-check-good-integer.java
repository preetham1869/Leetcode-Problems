class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0;
        int sq= 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            sq += digit * digit;
            n /= 10;
        }
        return sq - sum >= 50; 
    }
}