class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> mins = new ArrayList<>();
        for (String timePoint:timePoints){
            int hrs=(timePoint.charAt(0)-'0')*10+(timePoint.charAt(1)-'0');
            int min=(timePoint.charAt(3)-'0')*10+(timePoint.charAt(4)-'0');
            int totalMinutes=hrs*60+min;
            mins.add(totalMinutes);
        }
        Collections.sort(mins);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<mins.size();i++){
            minDiff =Math.min(minDiff,mins.get(i)-mins.get(i-1));
        }
        int finalMinDiff=Math.min(minDiff,1440+mins.get(0)-mins.get(mins.size()-1));
        return finalMinDiff;
    }
}