public class SelectionSort extends Sorter {

    public SelectionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    public void sortNums() {
        int temp;
        for (i = 0; i < nums.length-1; i++) {
            for (j = 1; j < nums.length; j++) {
                if (nums[j] < nums[j-1]) {
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                update();
            }
        }
    }
}