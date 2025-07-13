class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> fMap = new HashMap<>();
        for (String word : words) {
            fMap.put(word, fMap.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> fList = new ArrayList<>(fMap.entrySet());
        Collections.sort(fList, (a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(fList.get(i).getKey());
        }
        return res;
    }
}
