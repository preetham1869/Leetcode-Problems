class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character,Integer> mp=new HashMap<>();
       int st=0,maxi=0;
       for(int last=0;last<s.length();last++){
        char c=s.charAt(last);
        if(mp.containsKey(c) && mp.get(c)>=st) st=mp.get(c)+1;
        mp.put(c,last);
        maxi=Math.max(maxi,last-st+1);
       }
       return maxi;
    }
}