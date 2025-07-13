class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(Integer.toString(i));
        }
        Collections.sort(arr);
        List<Integer>res=new ArrayList<>();
        for(String s:arr){
            res.add(Integer.parseInt(s));
        }
        return res; 
    }
}