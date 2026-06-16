class Solution {
    public int[] singleNumber(int[] nums) {
       int[] arr=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++){
            int c=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    c++;
                }
            }
            if(c==1){
              arr[k]=nums[i];
              k++;
            }
        }
        return Arrays.copyOf(arr,k); 
    }
}