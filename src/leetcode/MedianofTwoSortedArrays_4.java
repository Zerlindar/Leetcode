package leetcode;

/**
 * Created by yongfeng on 17/5/2.
 */
public class MedianofTwoSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 == 0 && len2 == 0){
            return 0.0;
        }
        if(len1 == 0){
            if(len2 % 2 == 0){
                return (nums2[len2/2 - 1] + nums2[len2/2])/2.0;
            }else{
                return nums2[len2/2];
            }
        }
        if(len2 == 0){
            if(len1 % 2 == 0){
                return (nums1[len1/2 - 1] + nums1[len1/2])/2.0;
            }else{
                return nums1[len1/2];
            }
        }
        if((len1 + len2) % 2 == 0){
            int tmp1 = (findNthNumFromTwoArray(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2)) ;
            int tmp2 = (findNthNumFromTwoArray(nums1,0,len1 - 1,nums2,0, len2 - 1,(len1 + len2)/2 + 1 ) );
            return (findNthNumFromTwoArray(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2) + findNthNumFromTwoArray(nums1,0,len1 - 1,nums2,0, len2 - 1,(len1 + len2)/2 + 1 ) ) / 2.0;
        }else{
            return findNthNumFromTwoArray(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2)/2 + 1);
        }
    }

    private int findNthNumFromTwoArray(int[] nums1,int start1,int end1,int[] nums2, int start2,int end2 ,int n){
        if(start1 > end1){
            return nums2[start2 + n - 1];
        }
        if(start2 > end2){
            return nums1[start1 + n - 1];
        }
        if(n == 1){
            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
        }
        int n1 = n/2;
        int n2 = n - n1;
        if(start1 + n1 > end1){
            n1 = end1 - start1 + 1;
            n2 = n - n1 ;
        }
        if(start2 + n2 > end2){
            n2 = end2 - start2 + 1;
            n1 = n - n2;
        }
        int pos1 = n1 + start1 - 1;
        int pos2 = n2 + start2 - 1;

        if(nums1[pos1] < nums2[pos2]){
            return findNthNumFromTwoArray(nums1,pos1 + 1,end1,nums2,start2,pos2,n - n1);
        }else if(nums1[pos1] > nums2[pos2]){
            return findNthNumFromTwoArray(nums1,start1,pos1,nums2,pos2 + 1, end2,n - n2);
        }else{
            return nums1[pos1];
        }

    }


    public static void main(String[] args) {
        int[] nums1 = {5,6,7,8,9,10};
        int[] nums2 = {1,2,3,4};
        MedianofTwoSortedArrays_4 medianofTwoSortedArrays_4 = new MedianofTwoSortedArrays_4();
        System.out.println(medianofTwoSortedArrays_4.findMedianSortedArrays(nums1,nums2));
    }



}

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
Subscribe to see which companies asked this question.
 */