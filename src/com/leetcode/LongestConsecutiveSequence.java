package com.leetcode;


import java.util.*;

public class LongestConsecutiveSequence {


    public static void main(String[] args) {
        int[] nums = {3,1,4,2,2,7,9,8};
        longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        HashSet<Integer> visitedNum = new HashSet<>();


        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(visitedNum.contains(num)){
                continue;
            }else{
                visitedNum.add(num);
            }

            int endOfSequence = num - 1;
            int beginOfSequence = num + 1;

            LinkedList foundSequenceJoinAsEnd = null;
            LinkedList foundSequenceJoinAsBegining = null;

            //join as end of consequence
            if(map.containsKey(endOfSequence)){
                LinkedList<Integer> sequence = map.get(endOfSequence);
                if(sequence.getLast() == endOfSequence){
                    foundSequenceJoinAsEnd = sequence;
                    if(sequence.size() != 1) {
                        map.remove(endOfSequence);
                    }
                }
            }


            //join as beginning of consequence
            if(map.containsKey(beginOfSequence)){
                LinkedList<Integer> sequence = map.get(beginOfSequence);
                if(sequence.getFirst() == beginOfSequence){
                    foundSequenceJoinAsBegining = sequence;
                    if(sequence.size() != 1){
                        map.remove(beginOfSequence);
                    }
                }
            }

            if(foundSequenceJoinAsEnd != null && foundSequenceJoinAsBegining != null){
                foundSequenceJoinAsEnd.addLast(num);
                foundSequenceJoinAsEnd.addAll(foundSequenceJoinAsBegining);   //combine two sequence
                map.remove(foundSequenceJoinAsBegining.getLast());
                map.put((Integer) foundSequenceJoinAsBegining.getLast(), foundSequenceJoinAsEnd);

                continue;
            }else if(foundSequenceJoinAsEnd != null){
                foundSequenceJoinAsEnd.addLast(num);
                map.put(num, foundSequenceJoinAsEnd);
                continue;
            }else if(foundSequenceJoinAsBegining != null){
                foundSequenceJoinAsBegining.addFirst(num);
                map.put(num, foundSequenceJoinAsBegining);
                continue;
            }

            LinkedList<Integer> sequence = new LinkedList<>();
            sequence.add(num);
            map.put(num, sequence);

        }

        Iterator itr =map.entrySet().iterator();
        int max = 0;
        while(itr.hasNext()){
            Map.Entry pair = (Map.Entry)itr.next();
            LinkedList<Integer> result = (LinkedList<Integer>) pair.getValue();
            max = result.size() > max ? result.size() : max;
        }
        return max;
    }



}
