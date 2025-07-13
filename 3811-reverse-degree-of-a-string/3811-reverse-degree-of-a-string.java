class Solution {
    public int reverseDegree(String s) {
        int x= 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos= 26 - (c - 'a');
            x+= pos*(i + 1);
        }
        return x;
    }
}