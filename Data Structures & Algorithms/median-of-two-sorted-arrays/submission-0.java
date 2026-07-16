class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int p1 = 0;
        int p2 = 0;
        int med1 = 0;
        int med2 = 0;

        int mid = (nums1.length+nums2.length)/2;
        int count = 0;
        while(p1<nums1.length && p2<nums2.length && count <= mid){
            med2 =  med1;
            if(nums1[p1] < nums2[p2]){
                med1 = nums1[p1];
                p1++;
            } else {
                med1 = nums2[p2];
                p2++;
            }
            count++;
            System.out.println(med1);
        }

        while(count <= mid && p1<nums1.length){
            med2 =  med1;
            med1 = nums1[p1];
            p1++;
            count++;
        }

        while(count <= mid && p2<nums2.length){
             med2 =  med1;
            med1 = nums2[p2];
            p2++;
            count++;
           
        }

        if((nums1.length+nums2.length) % 2 == 0){
            return (med1+(double)med2)/2.0;
        } else {
            return med1;
        }

    }
}
