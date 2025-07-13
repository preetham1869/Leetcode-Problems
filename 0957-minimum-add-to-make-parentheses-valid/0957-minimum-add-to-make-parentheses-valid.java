class Solution {
    public int minAddToMakeValid(String s) {
        int i = 0;
        int countL = 0, countR = 0;;
        while(i < s.length()) {
            char c = s.charAt(i);
            if (c =='(') {
                countL ++;
            } else if (c == ')') {
                if(countL > 0) {
                    countL --;
                } else {
                    countR ++;
                }
            }
            i++;
        }
        return countL + countR;
    }
}