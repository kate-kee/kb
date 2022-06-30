public class CountSort {
    public static void Countsort(int[] nums,int range){
        int[] countfrequency=new int[range];
        for(int i=0;i<nums.length;i++){
            countfrequency[nums[i]]++;
        }
        int[] count_cummilative_freq=new int[range];
        count_cummilative_freq[0]=countfrequency[0];
        for(int i=1;i<range;i++){
            count_cummilative_freq[i]=count_cummilative_freq[i-1]+countfrequency[i];
        }
        int[] res=new int[nums.length];
        for(int j=nums.length-1;j>=0;j--){
          res[count_cummilative_freq[nums[j]]-1]=nums[j];
          count_cummilative_freq[nums[j]]=count_cummilative_freq[nums[j]]-1;
        }
        for(int x:res){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        int range=3;
        int[] nums = {2,0,2,1,1,0};
        Countsort(nums,range);
    }
}
