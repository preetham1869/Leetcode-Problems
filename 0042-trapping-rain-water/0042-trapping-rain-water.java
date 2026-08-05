class Solution {
    public int trap(int[] height) {
        // if(n==0)return;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, height[i]);
            leftMax[i] = maxi;
        }
        maxi = -1;
        for (int i = n - 1; i >= 0; i--) {
            maxi = Math.max(maxi, height[i]);
            rightMax[i] = maxi;
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}