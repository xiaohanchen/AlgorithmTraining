package com.leetcode;

public class Quicksort {


    public static void main(String[] args) {

        int[] theArray = {1,4,5,6,2,7,3};
        //=> 1,2,4,7,3


//        swapValues(0, 2, theArray);
        int leftIdx = 0;
        int rightIdx = theArray.length - 1;
        int pivotValue = theArray[rightIdx];
        quicksortArray(leftIdx, rightIdx, pivotValue, theArray);

        for(int i : theArray){
            print(i);
        }

    }

    private static <E> void print(E input){

        System.out.println(input);
    }

    static void swapValues(int indexOne, int indexTwo, int[] array1) {
        int temp = array1[indexOne];
        array1[indexOne] = array1[indexTwo];
        array1[indexTwo] = temp;
    }

    static void quicksortArray(int leftIndex, int rightIndex, int pivotValue, int[] theArray){

        if(rightIndex <= leftIndex) return;

        int pivotIndex = partitionArray(leftIndex, rightIndex, pivotValue, theArray);

        quicksortArray(leftIndex, pivotIndex-1 ,theArray[pivotIndex-1], theArray);
        quicksortArray(pivotIndex+1, rightIndex, theArray[rightIndex], theArray);


    }



    //which returns the pivot index
    static int partitionArray(int leftIndex, int rightIndex, int pivotValue, int[] theArray){

        while(true){
            while(theArray[leftIndex] < pivotValue && leftIndex < rightIndex){   //先对比再increment， 因为pivot value的位置可能被换很多次
                leftIndex++;
            }
            //if the array is sorted originally, leftIndex go straight to the end,
            // then rightIndex doesnt have any chance to move left at all

            while(theArray[rightIndex] > pivotValue && rightIndex > leftIndex){
                rightIndex--;
            }

            if(leftIndex < rightIndex){
                swapValues(leftIndex, rightIndex, theArray);
            }else{
                break;
            }
        }

        return leftIndex;

    }

}
