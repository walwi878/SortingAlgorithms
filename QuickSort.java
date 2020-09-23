public class QuickSort extends Sorter {


    public QuickSort(Integer[] nums) {
        super(nums);
    }

    public void sortNums() {
        quickSort(0, nums.length-1); 
    }

    public void quickSort(int left, int right){
        if(left < right){
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p + 1, right);
            update();
        }
    }

    public int partition(int left, int right){
        int pivot = nums[left];
        int hole = left, l = left +1, r = right;
        while(true){
            while(r > hole && nums[r] >= pivot){
                r--;
            }
            if(r == hole){
                break;
            }
            nums[hole] = nums[r];
            hole = r;
            while(l < hole && nums[l] < pivot){
                l++;
            }
            if( l == hole){
                break;
            }
            nums[hole] = nums[l];
            hole = l;
        }
        nums[hole] = pivot;
        return hole;
    }
}