class Solution {
    public String minWindow(String s, String t) {
        int[] need =new int[128];
        int[] window=new int[128];
        for(char c:t.toCharArray()){
            need[c]++;
        }
        int left=0;
        int cnt=0,start=0;
        int minLen=Integer.MAX_VALUE;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            window[c]++;
            if(window[c]<=need[c]){
                cnt++;
            }
            while(cnt==t.length()){
                if(r-left+1<minLen){
                    //since we want smallest windoww
                    minLen=r-left+1;
                    start=left;
                }
                char leftChar=s.charAt(left);
                window[leftChar]--;
                if(window[leftChar]<need[leftChar]){
                    cnt--;
                }
                left++;
            }
        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minLen);
    }
}