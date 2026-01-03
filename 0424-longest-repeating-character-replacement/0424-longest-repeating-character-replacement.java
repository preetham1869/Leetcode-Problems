class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int l=0,maxC=0,maxL= 0;
        for (int i=0;i<s.length();i++) {
            arr[s.charAt(i) - 'A']++;
            maxC= Math.max(maxC, arr[s.charAt(i) - 'A']);
            if ((i-l+1) - maxC > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            maxL= Math.max(maxL,i-l+1);
        }
        return maxL;
    }
}
