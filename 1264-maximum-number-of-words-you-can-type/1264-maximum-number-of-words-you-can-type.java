class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words= text.split(" ");
        int cnt=0;
        Set<Character> broken=new HashSet<>();
        for(char c:brokenLetters.toCharArray()){
            broken.add(c);
        }
        for(String word:words){
            boolean flag=true;
            for(char c:word.toCharArray()){
                if(broken.contains(c)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                cnt++;
            }
        }
        return cnt;
    }
}