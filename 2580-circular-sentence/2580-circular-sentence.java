class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n =arr.length;
        for(int i=0;i<n;i++){
            char last = arr[i].charAt(arr[i].length()-1);
            char secLast= arr[(i+1)%n].charAt(0);
            if(last!=secLast)return false;
        }
        return true;
    }
}