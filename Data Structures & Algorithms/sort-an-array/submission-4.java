class Solution {
    public int[] sortArray(int[] nums) {
       quickSort(nums, 0, nums.length-1);
       return nums;
    }
    int[] bubbleSort(int[] nums){
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n-1-i; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    int[] insertionSort(int[] nums){
        int n = nums.length;
        for(int i = 1; i<n; i++){
           int j = i-1;
           int pivot = nums[i];
           while(j>=0 && nums[j] > pivot){
            nums[j+1] = nums[j];
            j = j-1;
           }
           nums[j+1] = pivot;
        }
        return nums;
    }
    void mergeSort(int[] nums, int l, int n){
        if(l >= n) return;
        int m = (l+n)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, n);
        merge(nums, l, m, n);

        
    }
    void merge(int[] nums, int l, int m, int n){
        int[] left = new int[m-l+1];
        int[] right = new int[n-m];
        int i = 0;
        while(i < left.length){
            left[i] = nums[l+i];
            i++; 
        }
        int j = 0;
        while(j < right.length){
            right[j] = nums[m+j+1];
            j++;
        }
        i = 0;
        j = 0;
        while(i < left.length && j < right.length){
            if(left[i]<right[j]){
                nums[l++] = left[i++];
            } else {
                nums[l++] = right[j++];
            }
        }
        while(i < left.length ){
             nums[l++] = left[i++];
        }
        while(j < right.length ){
             nums[l++] = right[j++];
        }
    }
    void quickSort(int[] arr, int l, int r){

        if(l >= r) return;
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot-1);
        quickSort(arr, pivot+1, r);
    }
    int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l-1;
        int j = l;
        while(j <= r){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[r] = temp;
        return i+1;
    }

}