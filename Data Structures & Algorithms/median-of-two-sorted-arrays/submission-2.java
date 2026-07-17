class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
      if(nums2.length < nums1.length){
        int[] arr = nums2;
        nums2 = nums1;
        nums1 = arr;
      }
      int mid = (nums1.length + nums2.length + 1)/2;
      int l = 0;
      int r = nums1.length;
      while(l <= r){
        int m = l + (r - l)/2;
        int aLeft = (m > 0 ? nums1[m - 1]: Integer.MIN_VALUE);
        int aRight = (m < nums1.length ? nums1[m] : Integer.MAX_VALUE);

        int m2 = mid - m;
        int bLeft = (m2 > 0 ? nums2[m2-1]: Integer.MIN_VALUE);
        int bRight = (m2 < nums2.length ? nums2[m2]: Integer.MAX_VALUE);

        System.out.println(aLeft +"--"+bRight+"--"+bLeft+"--"+aRight);
        if(aLeft<=bRight && bLeft <= aRight){

            if((nums1.length + nums2.length)%2 == 0 ){
                return (Math.max(aLeft, bLeft) + (double)Math.min(aRight, bRight)) / 2.0;
            } else {
                return Math.max(aLeft, bLeft);
            }

        } else if(aLeft > bRight) {
            r = m - 1;
        } else {
            l = m+1;
        }



      }
      return -1;

    }
}
