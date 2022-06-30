public class maximumsumarray {
    public static int maximumSumArray(int[] nums){
        int max_so_far = nums[0];
        int curr_max = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
               curr_max = Math.max(nums[i], curr_max+nums[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    public static void main(String[] args){
      int[] nums=   {-2, -3, 4, -1, -2, 1, 5, -3};
      System.out.println(maximumSumArray(nums));
    }
}
