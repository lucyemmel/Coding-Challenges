class Solution {
    private double getMedian(int [] nums) {
        if(nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }
        else {
            return nums[nums.length / 2];
        }
    }
    
    private int [] mergeSorted(int [] nums1, int [] nums2) {
        int [] res = new int[nums1.length + nums2.length];
        int i, j, k;
        i = j = k = 0;
        
       // merge arrays into new array 
       while(j < nums1.length && k < nums2.length) {
           if(nums1[j] < nums2[k]) {
               res[i] = nums1[j];
               i++;
               j++;
           }
           else {
               res[i] = nums2[k];
               i++;
               k++;
           }
       }
        
        // consume remaining elements in one of the arrays
        while(j < nums1.length) {
            res[i] = nums1[j];
               i++;
               j++;
        }
        
        while(k < nums2.length) {
            res[i] = nums2[k];
               i++;
               k++;
        }
        
        return res;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] merged = mergeSorted(nums1, nums2);
        System.out.println(Arrays.toString(merged));
        return this.getMedian(merged);
    }
}