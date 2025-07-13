class Solution {
    public int maximumLength(String s) {
        Map<Character,Integer> m =new HashMap<>();
        int n=s.length();
        int k;
        for(int i=0;i<n;i++)m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        char ch;
        int res=-1;
        for(Map.Entry<Character,Integer> entry : m.entrySet()){
            if(res<entry.getValue()){
                res=entry.getValue();
                ch=entry.getKey();
            }
        }
        int cnt=0,flag=0;
        for(k=n-2;k>1;k--){
            for(Map.Entry<Character, Integer> a:m.entrySet()){
                cnt=0;
                for(int i=0;i<=n-k;i++){
                    flag=0;
                    for(int j=i;j<i+k-1;j++){
                        if(s.charAt(j)!=s.charAt(j+1) || s.charAt(j)!=a.getKey()){
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0)cnt++;
                }
                if(cnt>=3)return k;
            }
        }
        if(k==1&&res>=3)return 1;
        return -1;
    }
}