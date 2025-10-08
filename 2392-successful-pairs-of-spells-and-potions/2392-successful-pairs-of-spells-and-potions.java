class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=potions.length;
        Arrays.sort(potions);
        int ans[]=new int[spells.length];///for successfull pairs.........
        for(int i=0;i<spells.length;i++){// for taking each spell in an array....
            long spellPower=spells[i];
            long minPower=(success+spellPower-1)/spellPower;// for MinPotionPower......
            int l=0,r=n-1;
            while(l<=r){
              int mid=(l+r)/2;
              if(potions[mid]<minPower) l=mid+1;
              else r=mid-1; 
            }
            ans[i]=n-l;
        }
        return ans;
    }
}