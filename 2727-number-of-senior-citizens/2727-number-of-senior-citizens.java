class Solution {
    public int countSeniors(String[] details) {
        int cnt=0;
        for(String data:details){
            int age = Integer.parseInt(data.substring(11, 13));
            if(age>60)cnt++;
        }
        return cnt;
    }
}