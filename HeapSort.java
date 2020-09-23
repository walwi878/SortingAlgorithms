import java.util.*;

public class HeapSort extends Sorter {

    public HeapSort(Integer[] nums) {
        super(nums);
    }

    public void sortNums() {
        heapify();
        int size = nums.length;
        while(size > 1){
            swap(0, size-1);
            size--;
            siftDown(0, size);
        }
    }
    
    private void heapify() {
      int n = nums.length;
      for(int i = (n / 2) - 1; i >= 0; i--){
            siftDown(i, n);
        }
    }

    private void siftDown(int index, int size) {
        int biggestChild = getLargerChildIndex(index, size);
        if(biggestChild == -1){ ////// REMEMBER
            return;
        } else {
            if(nums[biggestChild] > nums[index]){
                swap(biggestChild, index);
                siftDown(biggestChild, size);
            }
        }
    }
    
    private int getLargerChildIndex(int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if(left >= size){
            return -1;
        }
        if(right >= size){
            return left;
        } else {
            if(nums[left] > nums[right]){
                return left;
            } else {
                return right;
            }
        }
    }
    
    //    private void swap(int x, int y) {
//      i = x;
//      j = y;
//      int tmp = nums[i];
//      nums[i] = nums[j];
//      nums[j] = tmp;
//      update();
//    }
    
}