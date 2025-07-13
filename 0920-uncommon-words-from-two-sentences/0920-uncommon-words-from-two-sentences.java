class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
     String str = s1+" "+s2;
     String[] arr = str.split(" ");
     int n = arr.length;
     ArrayList<String>res=new ArrayList<>();
     int cnt=0;
     for(int i=0;i<n;i++){
        cnt=0;
        for(int j=0;j<n;j++){
            if(i!=j && arr[i].equals(arr[j])){
                cnt++;
            }
        }
        if(cnt==0)res.add(arr[i]);
     }
     return res.toArray(new String[0]);
    }
}