class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int canditate1=0,canditate2=0;
        int cnt1=0,cnt2=0;
        int n=nums.length;
        for(int num:nums){
            if(num==canditate1)cnt1++;
            else if(num==canditate2)cnt2++;
            else if(cnt1==0){
                canditate1=num;
                cnt1=1;
            }
            else if(cnt2==0){
                canditate2=num;
                cnt2=1;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int num:nums){
            if(num==canditate1)cnt1++;
            else if(num==canditate2)cnt2++;
        }
        List<Integer> ans=new ArrayList<>();
        if(cnt1>n/3)ans.add(canditate1);
        if(cnt2>n/3)ans.add(canditate2);
        return ans;
    }
}