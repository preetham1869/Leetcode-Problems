class Solution {
    public int minimumChairs(String s) {
        int cnt = 0;
        int maxi = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'E') {
                cnt++;
                maxi = Math.max(maxi, cnt);
            }
            else cnt--;
        }
        return maxi;
    }
}