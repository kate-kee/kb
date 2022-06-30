import java.util.Arrays;

public class countinversion {
    public static int getInversion(int nums[],int low, int high){
        int count=0;
        if(low<high){
            int mid=low+(high-low)/2;
            count+=getInversion(nums,low,mid);
            count+=getInversion(nums,mid+1,high);
            count+=merge(nums,low,mid,high);
        }

        return count;

    }
    public static int merge(int[] nums,int low,int mid,int high){
        int[] left=Arrays.copyOfRange(nums,low,mid+1);
        int[] right=Arrays.copyOfRange(nums,mid+1,high+1);
        int i=0;
        int j=0;
        int count=0;
        int k=low;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                nums[k++]=left[i++];
            }
            else{
                nums[k++]=right[j++];
                count+=(mid+1)-(low+i);
            }
        }
        while(i<left.length){
            nums[k++]=left[i++];
        }
        while(j<right.length){
            nums[k++]=right[j++];
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums={8,4,2,1};
        int count=getInversion(nums,0,nums.length-1);
        System.out.println(count);

    }
}
