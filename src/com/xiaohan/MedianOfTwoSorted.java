package com.xiaohan;

public class MedianOfTwoSorted {

    //division in java is ROUND DOWN
    //if the median of arrayM > m of arrayK, that means the left part of array K and right part of array M will not contribute into the calculation of the median
    //because if mM = mK, then the median is average of the mM & mK; if mM > mK, then "one element to the right of mK" or "one element to the left of mM"
    // might be taken into account to calculate the median, which means left part of array K and right part of array M will not contribute into the calculation of the median


    public static void main(String[] args) {
        int[] arrayM = {1,3,5,7,9};
        int[] arrayN = {2,4,9,9,10};

        Main.print(6/2);


        double median = findMedianSortedArrays(arrayN, arrayM);
        Main.print(median);

        boolean isEven = (arrayN.length + arrayM.length)%2 == 0;
    }

    public static double findMedianSortedArraysXiaohan(int[] mNums, int[] nNums, int k, int mStart, int mEnd, int nStart, int nEnd) {

        //convert the find median problem into the find Kth value by binary search
        int mLen = mEnd - mStart;
        int nLen = nEnd - nStart;

        if(mLen == 0){
            return nNums[nStart + k];
        }else if(nLen == 0){
            return mNums[mStart + k];
        }else if(k == 0){
            //here we have found the Kth value
            //when k is zero, the smalles number in the two arraies must be the Kth value
            return mNums[mStart] < nNums[nStart] ?mNums[mStart] : nNums[nStart];
        }



        int mMid = k * (mLen / (mLen + nLen));
        int nMid = k - mMid - 1;    //because k is in the context of the merged array, here since arrayN is divided from the merged one, it starts from 0, so need to -1

        mMid = mStart + mMid;
        nMid = nStart + nMid;

        if(mNums[mMid] == nNums[nMid]){
            return mNums[mMid];

        }else if(mNums[mMid] > nNums[nMid]){
            k = k - (nMid + 1);   //remove left part of numsM including the mMid  TODO dodgy
            nStart = nMid + 1;
            mEnd = mMid;
            findMedianSortedArraysXiaohan(mNums, nNums, k, mStart, mEnd, nStart, nEnd);

        }else if(mNums[mMid] < nNums[nMid]){
            k = k - (mMid + 1);   //remove left part of numsM including the mMid  TODO dodgy
            mStart = mMid + 1;
            nEnd = nMid;
            findMedianSortedArraysXiaohan(mNums, nNums, k, mStart, mEnd, nStart, nEnd);
        }

        return 0;
    }














    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        if(total%2==0){
            return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
        }else{
            return findKth(total/2+1, nums1, nums2, 0, 0);
        }
    }

    public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
        if(s1>=nums1.length)
            return nums2[s2+k-1];

        if(s2>=nums2.length)
            return nums1[s1+k-1];

        if(k==1)
            return Math.min(nums1[s1], nums2[s2]);

        int m1 = s1+k/2-1;
        int m2 = s2+k/2-1;

        int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;
        int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;

        if(mid1<mid2){
            return findKth(k-k/2, nums1, nums2, m1+1, s2);
        }else{
            return findKth(k-k/2, nums1, nums2, s1, m2+1);
        }
    }
}
