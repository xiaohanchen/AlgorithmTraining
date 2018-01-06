package com.xiaohan;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

import java.util.HashMap;

public class HashMapPractise {

    static class AObject{

    }


    public static void main(String[] args) {
        HashMap<Integer, AObject> hashmap = new HashMap<>();

        AObject aObject = new AObject();
        hashmap.put(1, aObject);
        hashmap.put(2, aObject);

        Main.print(hashmap.containsValue(aObject));
        Main.print(hashmap.get(1));
        Main.print(hashmap.get(2));


        HashMap<Integer, Integer> hashmapInt = new HashMap<>();
        hashmapInt.put(1,2);
        hashmapInt.put(1,3);
        Main.print(hashmapInt.get(1));





    }
}
