class Solution {
    public List<String> removeSubfolders(String[] folder) {
        //Arrays.sort(folder);//Sorting is done in lexicographical order
        Arrays.sort(folder);
        String prev =null;
        List<String> res = new ArrayList<>();
        for(String s : folder){                                //a
            if(prev==null|| !s.startsWith(prev+'/')){           // ab -> false , cd -> true
                res.add(s);                                    //ans = {a , cd}
                prev = s;                                      // prev = cd
            }
        }
        return res;
    }
}