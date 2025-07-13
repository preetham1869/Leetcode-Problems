class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
      Arrays.sort(students);
      Arrays.sort(seats);
      int res=0;
      for(int k=0;k<seats.length;k++)
      res+=Math.abs(students[k]-seats[k]);
      return res;  
    }
}