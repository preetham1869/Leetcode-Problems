class Solution {
    public int earliestTime(int[][] tasks) {
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            int sum = tasks[i][0] + tasks[i][1];
            mini = Math.min(mini, sum);
        }
        return mini;
    }
}