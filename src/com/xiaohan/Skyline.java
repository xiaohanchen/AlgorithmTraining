package com.xiaohan;

import org.omg.CORBA.INTERNAL;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Skyline {


    public static void main(String[] args) {

        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        Skyline program = new Skyline();
        program.getSkyline(buildings);
    }


    public List<int[]> getSkyline(int[][] buildings) {



        //store the current height
        //if (B lower than A): if(A covers B)  => ignore B
        //                              else  => take B's height

        //TODO: Method1: list of height:  iterate through each building, the list records the heghist point
        //TODO: Method2: only record the start and end


        HashMap<Integer, Integer> skyline = new HashMap<>();
        Point skylineEndPoint = null;
        for(int[] building : buildings){
            int leftP = building[0];
            int rightP = building[1];
            int heigh = building[2];
            if(skylineEndPoint== null){
                skylineEndPoint = new Point(rightP, heigh);
                skyline.put(leftP, heigh);
                continue;
            }

            if(leftP > skylineEndPoint.x){
                skyline.put(skylineEndPoint.x,0);
                skyline.put(leftP, heigh);
                skylineEndPoint = new Point(rightP, heigh);
                continue;
            }


            //previous building overlaps current one
            if(heigh > skylineEndPoint.y){
                //rise
                if(rightP > skylineEndPoint.x) {
                    skyline.put(leftP, heigh);   //if duplicate, it overrides
                    skylineEndPoint.x = rightP;
                    skylineEndPoint.y = heigh;
                }else{
                    //completely covers
                    skyline.put(leftP, heigh);   //if duplicate, it overrides
                    skyline.put(rightP, skylineEndPoint.y);   //if duplicate, it overrides
                }
            }else{
                //drop
                if(rightP > skylineEndPoint.x){
                    skyline.put(skylineEndPoint.x, heigh);
                    skylineEndPoint.x = rightP;
                    skylineEndPoint.y = heigh;
                }
            }
        }

        List<int[]> res = new ArrayList<int[]>();
        for(Map.Entry<Integer, Integer> entry : skyline.entrySet()){
            int[] point = new int[2];
            point[0] = entry.getKey();
            point[1] = entry.getValue();
            res.add(point);
        }
        return res;
    }


}


class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
