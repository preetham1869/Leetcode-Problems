class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> uniqueElements = new TreeSet<>();
        for (int num : arr) {
            uniqueElements.add(num);
        }
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : uniqueElements) {
            rankMap.put(num, rank);
            rank++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
}