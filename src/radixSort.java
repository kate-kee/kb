import java.util.Arrays;

class radixSort{
    public static void countSort(int[] nums,int exp){
        int[] count=new int[10];
        Arrays.fill(count, 0);
        for(int i=0;i<nums.length;i++){
            count[(nums[i]/exp)%10]++;
        }
        int[] count_cummilative_freq=new int[10];
        count_cummilative_freq[0]=count[0];
        for(int i=1;i<10;i++){
            count_cummilative_freq[i]=count_cummilative_freq[i-1]+count[i];
        }
        int[] res=new int[nums.length];
        for(int j=nums.length-1;j>=0;j--){
          res[count_cummilative_freq[(nums[j]/exp)%10]-1]=nums[j];
          count_cummilative_freq[(nums[j]/exp)%10]=count_cummilative_freq[(nums[j]/exp)%10]-1;
        }
        for(int x=0;x<nums.length;x++){
            nums[x]=res[x];
        }
    }
    public static void RadixSort(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
        }
       for(int x=1;max/x>0;x=x*10){
        countSort(nums,x);
    }
    for(int i:nums){
        System.out.println(i);
    }
    }
    public static void main(String[] args){
        int nums[]={150,90,802,2,24,75};
        RadixSort(nums);
    }
}