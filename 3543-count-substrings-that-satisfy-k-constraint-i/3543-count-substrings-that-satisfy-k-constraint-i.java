class Solution {
    public int countKConstraintSubstrings(String s, int k) {
    int cnt=0;
    int n=s.length();
    for (int i=0;i<n;i++){
        int zeros=0,ones=0;
        for (int j=i;j<n;j++) {
            if (s.charAt(j) == '0')zeros++;
            else ones++;
            if (zeros>k && ones>k){
                break;
            }
            cnt++;
        }
    }
    return cnt;
    }
}