class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans=new ArrayList<>();
        for(String word:words){
            if(!ans.isEmpty() && AN(ans.get(ans.size()-1),word))
            continue;
            ans.add(word);
        }
        return ans;
    }
    private static boolean AN(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);   
    }
}