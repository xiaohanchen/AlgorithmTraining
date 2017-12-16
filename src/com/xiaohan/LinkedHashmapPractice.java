package com.xiaohan;

import java.util.LinkedHashMap;
import java.util.Map;

//linkedHashMap keeps insertion order
//but HashMap doesn't
public class LinkedHashmapPractice {

    public static void main(String[] args) {

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();


        linkedHashMap.put(1,"a1");
        linkedHashMap.put(2,"a2");
        linkedHashMap.put(3,"a3");

        linkedHashMap.remove(2);
        linkedHashMap.put(2,"a2");

        for(Map.Entry m:linkedHashMap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }



    }
}
