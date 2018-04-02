package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListPractise {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new java.util.LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

//        Main.print(linkedList.getFirst());
//        Main.print(linkedList.getLast());
        linkedList.addFirst(4);
        linkedList.remove(Integer.valueOf(2)); //Deletion in the linkedList is O(n)

        Iterator<Integer> iterator = linkedList.iterator();   //illegal to add items after the creation of iterator
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //It is not possible to have cycle in java.util.linkedlist

    }


}
