class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorS=0;
        for(int num : derived)xorS^= num;
        return xorS == 0;
    }
}