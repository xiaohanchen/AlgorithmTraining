//package com.xiaohan;
//
//import java.util.*;
//
//public class CanIWin {
//
//
//    public static void main(String[] args) {
//
//
//        canIWin(10,11);
//    }
//
//    public static  boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//
//        //if we know all the possibilities of combination which > desiredTotal, is the num of nums in the combination is odd, then true
//        //sum 5 have combinations of a,b,c ; Therefore sum 6 should have the  6, a+1,b+1,c+1 is 1 is available
//        //< desiredTotal: Even
//        // = desiredTotoal: Odd
//        //O(m*n)   m is desiredTotal
//
//        HashMap<Integer, List<Set<Integer>>> record = new HashMap<>();
//
//        for(int tempSum=1; tempSum<=desiredTotal; tempSum++){
//            for(int i=1; i <= maxChoosableInteger; i++){
//                int gap = tempSum - i;
//                if(gap < 0){
//                    break;
//                }else if(gap == 0){
//                    if(record.containsKey(tempSum)){
//                        record.get(tempSum).add(new HashSet<Integer>(Arrays.asList(i)));
//                    }else{
//                        List tempList= new ArrayList<Set<Integer>>();
//                        tempList.add(new HashSet<Integer>(Arrays.asList(i)));
//                        record.put(tempSum, tempList);
//                    }
//
//                }else{
//                    List<Set<Integer>> combinations = new ArrayList<>(record.get(gap));
//                    for (Set<Integer> set : combinations){
//                        if(set.contains(i)){
//                            continue;
//                        }else{
//                            set.add(i);
//                            if(record.containsKey(tempSum)){
//                                record.get(tempSum).add(set);
//                            }else{
//                                List tempList= new ArrayList<Set<Integer>>();
//                                tempList.add(set);
//                                record.put(tempSum, tempList);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return false;
//    }
//
//
//
//
//
//    static HashMap<Integer, Boolean> map = new HashMap<>();
//    public static  boolean canIWinDFS(int maxChoosableInteger, int desiredTotal) {
//        boolean[] used = new boolean[maxChoosableInteger+1];
//
//
//
//
//
//
//        return true;
//    }
//
//
//    boolean DFS(boolean[] used, int desiredTotal){
//
//        if(desiredTotal < 0){
//            return true;
//        }
//
//        for(int i=1; i <=used.length-1; i++){
//            if(!used[i]){
//                used[i] = true;
//                if(!DFS(used, desiredTotal - i)){
//                    return true;
//                }else{
//                    used[i] = false;   //using num i as start is not correct, so revert it.
//                    int key =  used;  //TODO used array transform to int
//                    map.put(key, true);
//                }
//            }
//
//
//
//        }
//    }
//
//}