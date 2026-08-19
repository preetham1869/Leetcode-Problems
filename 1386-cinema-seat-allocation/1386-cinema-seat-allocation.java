class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int[] seat : reservedSeats) {
            mp.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }
        int ans = (n - mp.size()) * 2;
        for (Set<Integer> seats : mp.values()) {
            boolean left = true;
            boolean middle = true;
            boolean right = true;
            for (int s = 2; s <= 5; s++) {
                if (seats.contains(s)) {
                    left = false;
                    break;
                }
            }
            for (int s = 4; s <= 7; s++) {
                if (seats.contains(s)) {
                    middle = false;
                    break;
                }
            }
            for (int s = 6; s <= 9; s++) {
                if (seats.contains(s)) {
                    right = false;
                    break;
                }
            }
            if (left && right)
                ans += 2;
            else if (left || middle || right)
                ans += 1;
        }
        return ans;
    }
}