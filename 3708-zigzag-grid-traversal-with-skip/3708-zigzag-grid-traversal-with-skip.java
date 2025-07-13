class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean leftToRight = true;
        for (int i = 0; i < rows; i++) {
            if (leftToRight) {
                for (int j = 0; j < cols; j++) {
                    if ((i + j) % 2 == 0) {
                        result.add(grid[i][j]);
                    }
                }
            } 
            else {
                for (int j = cols - 1; j >= 0; j--) {
                    if ((i + j) % 2 == 0) {
                        result.add(grid[i][j]);
                    }
                }
            }
            leftToRight = !leftToRight;
        }
        return result;
    }
}