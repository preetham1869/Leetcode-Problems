class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int[] arr = new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length ){
            if(nums1[i] <= nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of nums1[] if any
        while(i<nums1.length){
            arr[k] = nums1[i];
           i++;
            k++;
        }
        // Copy remaining elements of nums2[] if any
        while(j<nums2.length){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        if((nums1.length+nums2.length)%2==1){
            double ans=arr[(nums1.length+nums2.length)/2];
            return ans;
        }
        else{
            int x=(nums1.length+nums2.length)/2;
            double res=(arr[x]+arr[x-1]);
            return res/2;
        }
    }
}