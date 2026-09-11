class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        Set<Integer> res= new HashSet<>();
        Set<Integer> even= new HashSet<>(); 
        for (int digit : digits) {
            if (digit % 2 == 0) {
                even.add(digit);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && i != k && j != k) {
                        if (digits[i] != 0) {
                            int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                            if (even.contains(digits[k])) {
                                res.add(num);
                            }
                        }
                    }
                }
            }
        }
        return res.size();
    }
}