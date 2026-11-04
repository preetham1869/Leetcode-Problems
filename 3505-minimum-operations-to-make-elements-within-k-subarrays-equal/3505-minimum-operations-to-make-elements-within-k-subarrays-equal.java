
import java.util.*;

class Solution {
    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    long sumLow = 0, sumHigh = 0;
    int sizeLow = 0, sizeHigh = 0;

    void addLow(int v) {
        low.put(v, low.getOrDefault(v, 0) + 1);
        sumLow += v;
        sizeLow++;
    }

    void addHigh(int v) {
        high.put(v, high.getOrDefault(v, 0) + 1);
        sumHigh += v;
        sizeHigh++;
    }

    void removeLow(int v) {
        if (low.get(v) == 1)
            low.remove(v);
        else
            low.put(v, low.get(v) - 1);

        sumLow -= v;
        sizeLow--;
    }

    void removeHigh(int v) {
        if (high.get(v) == 1)
            high.remove(v);
        else
            high.put(v, high.get(v) - 1);

        sumHigh -= v;
        sizeHigh--;
    }

    void balance() {
        while (sizeLow > sizeHigh + 1) {
            int v = low.lastKey();
            removeLow(v);
            addHigh(v);
        }

        while (sizeLow < sizeHigh) {
            int v = high.firstKey();
            removeHigh(v);
            addLow(v);
        }
    }

    void add(int v) {
        if (low.isEmpty() || v <= low.lastKey())
            addLow(v);
        else
            addHigh(v);

        balance();
    }

    void remove(int v) {
        if (low.containsKey(v))
            removeLow(v);
        else
            removeHigh(v);

        balance();
    }

    long getCost() {
        long median = low.lastKey();

        return median * sizeLow - sumLow
             + sumHigh - median * sizeHigh;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            if (i >= x)remove(nums[i - x]);
            if (i >= x - 1)cost[i - x + 1] = getCost();
        }
        long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);
            for (int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];
                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(curr[i],prev[i-x]+cost[i-x]);
                }
            }
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n];
    }
}