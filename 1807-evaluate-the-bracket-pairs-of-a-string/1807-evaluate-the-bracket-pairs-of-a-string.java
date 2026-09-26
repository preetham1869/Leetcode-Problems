class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> mp=new HashMap<>();
        for(List<String> pair:knowledge){
            mp.put(pair.get(0),pair.get(1));
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                int j=i+1;
                while (s.charAt(j) != ')'){
                    j++;
                }
                String key = s.substring(i+1,j);
                if (mp.containsKey(key))ans.append(mp.get(key));
                else ans.append("?");
                i=j;
            }
            else ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}