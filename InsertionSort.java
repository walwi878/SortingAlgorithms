public class InsertionSort extends Sorter {

    public InsertionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    public void sortNums() {
        int temp;
        for (i = 1; i < nums.length; i++) {
            temp = nums[i];
            for (j = i-1; j >= 0; j--){
                if  (nums[j] > temp) {
                    nums[j+1] = nums[j];
                    update();
                }else{
                    break;
                }               
            }
            nums[j+1] = temp;
            update();
        }
    }
}
