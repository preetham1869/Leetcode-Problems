class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int t=numBottles,e=numBottles;
        while(e>=numExchange){
            int x=e/numExchange;
            t+=x;
            e=e%numExchange+x;
        }
        return t;
    }
}