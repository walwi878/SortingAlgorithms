import java.util.*;

public class MergeSort extends Sorter {


    public MergeSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }


    private void mergeSort(Integer[] nums, int left, int right) {
        //if (right - left <= 1) return;
        if (left< right){ // necessary?
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid + 1, right);
        }
        
    }

    public void sortNums(){
        mergeSort(nums, 0, nums.length-1);
    }
    
    private void merge(Integer[] nums, int left, int mid, int right) {
        
        int[] temp = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            temp[i] = nums[i];
        }
      
        int i= left;
        int j = left;
        int k = mid;
        while (i < mid && k <= right){
            if (temp[i] < temp[k]){
                nums[j++] = temp[i++];
            } else {
                nums[j++] = temp[k++];
            }
        }
        while (i < mid){
            nums[j++] = temp[i++];
        }
        while (j <= right){
            nums[j++] = temp[k++];
        }
        update();
    }
}
