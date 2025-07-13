class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxi=0;
        int res=-1;
        for(int i=0;i<events.length;i++){
            int time;
            if(i==0)time = events[i][1];
            else time=events[i][1]-events[i-1][1];
            if(time>maxi ||(time == maxi && events[i][0] < res)){
                maxi=time;
                res=events[i][0];
            }
        }
        return res;
    }
}