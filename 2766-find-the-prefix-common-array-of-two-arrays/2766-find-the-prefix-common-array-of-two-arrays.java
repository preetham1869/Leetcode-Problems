class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] arr=new int[n];
        Set<Integer> stA = new HashSet<>();
        Set<Integer> stB = new HashSet<>();
        int cnt=0;// Which is Common in both..........
        for(int i=0;i<n;i++){
            stA.add(A[i]);
            stB.add(B[i]);
            if(stB.contains(A[i]))cnt++;
            if(stA.contains(B[i]) && A[i]!=B[i])cnt++;
            arr[i]=cnt;
        }
        return arr;
    }
}