class MyHashMap {
    int n = 10000;
    ArrayList<ArrayList<int[]>> arr;
    public MyHashMap() {
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
    }
    public void put(int key, int value) {
        int idx = key % n;
        for (int[] p : arr.get(idx)) {
            if (p[0] == key) {
                p[1] = value;
                return;
            }
        }
        arr.get(idx).add(new int[]{key, value});
    }
    public int get(int key) {
        int idx = key % n;
        for (int[] p : arr.get(idx)) {
            if (p[0] == key) {
                return p[1];
            }
        }
        return -1;
    }
    public void remove(int key) {
        int idx = key % n;
        for (int i = 0; i < arr.get(idx).size(); i++) {
            if (arr.get(idx).get(i)[0] == key) {
                arr.get(idx).remove(i);
                return;
            }
        }
    }
}