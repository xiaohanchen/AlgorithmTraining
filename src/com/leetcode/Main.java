package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {


    //Single Line
    /* text */




    //Multiple Line
    /** documen
     * tation */



    public static void main(String[] args) {
	// write your code here

        List<Integer> arrayInt = new ArrayList<>();
        arrayInt.add(1);
        arrayInt.add(2);
        arrayInt.add(3);

        List<Integer> arrayInt2 = arrayInt;
        arrayInt2.add(4);


        List<Integer> arrayInt3 = new ArrayList<>(arrayInt);
        arrayInt3.add(5);
        print(arrayInt.size());
        print(arrayInt2.size());

        print(arrayInt.size());
        print(arrayInt3.size());


        int aInt = 5;
        int bInt = aInt;
        aInt = 8;

        print(aInt);
        print(bInt);





        String name = "chenxiaohan";
        String surname = name.substring(0, 1);
        print(surname);



        int int1 = 8;
        int int2 = 10;

        int[] intArray = {1,2,3,4,5,6,7};
        print("aaa");
        print(int1);
        print(int2);
        print(intArray.length);

        int maxIntPos = 2147483647;
        int maxIntNeg = -2147483648;
        print(maxIntPos + 1 );
        print(maxIntNeg + maxIntPos);





        LinkedList<String> al=new LinkedList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        print(al.peek());
        print(al.pop());
        print(al.remove());




    }



    public static <E> void print(E input){

        System.out.println(input);
    }
}
