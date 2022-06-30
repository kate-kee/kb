public class quickSort {
    public static void sort(int nums[],int low,int high){
        if(low<high){
           int pi= partition(nums,low, high);
            sort(nums,low,pi-1);
            sort(nums,pi+1,high);
        }
    }
    public static int partition(int nums[],int low,int high){
        int i=low-1;
        int p=nums[high];
        for(int j = low; j <= high - 1; j++){
            if(nums[j]<p){
                i++;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        int temp=nums[i+1];
        nums[i+1]=nums[high];
        nums[high]=temp;
        return i+1;
    }
    static void printArray(int[] arr, int size)
    {
    for(int i = 0; i < size; i++)
        System.out.print(arr[i] + " ");
    System.out.println();
    }
    public static void main(String[] args){
        int[] a={23,42,7,5,45,7,24};
        sort(a,0,a.length-1);
        printArray(a, a.length);
    }
}