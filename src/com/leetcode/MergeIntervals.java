package com.leetcode;

import java.util.*;

public class MergeIntervals {


    public static void main(String[] args) {
        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(5,9);
        Interval i3 = new Interval(3,5);
        MergeIntervals mergeIntervals = new MergeIntervals();
//        mergeIntervals.merge(Arrays.asList(i1,i2,i3));




        mergeIntervals.insert( Arrays.asList(new Interval(1,3), new Interval(6,9)), new Interval(2,5) );
    }



    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
            return null;
        }

        //O(nlogn) to sort, O(n) to go through all intervals to merge

        List<Interval> mergedInterval = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start < o2.start){
                    return -1; //is 1st item smaller than 2nd item
                }else if (o1.start > o2.start){
                    return 1;
                }
                return 0;
            }
        });

        int start = intervals.get(0).start;
        int end =intervals.get(0).end;

        for(Interval interval : intervals){
            int tempStart = interval.start;
            int tempEnd = interval.end;
            if(tempStart <= end){
                if(tempEnd > end){
                    end = tempEnd;
                }
            }else{
                mergedInterval.add(new Interval(start, end));
                start = tempStart;
                end = tempEnd;
            }
        }
        mergedInterval.add(new Interval(start, end));

        return mergedInterval;
    }




    /*  insert interval to sorted merged intervals    */
    /*  insert interval to sorted merged intervals    */
    /*  insert interval to sorted merged intervals    */


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> mergedIntervals = new ArrayList<>();
        int newIntervalStart = newInterval.start;
        int newIntervalEnd = newInterval.end;
        boolean isStartAssigned = false;
        int mergedStart = 0;
        int mergedEnd = 0;

        if(intervals.size() == 0){
            return Arrays.asList(newInterval);
        }

        if( newIntervalStart > intervals.get(intervals.size()-1).end){
            intervals.add(newInterval);
            return intervals;
        }

        if(newIntervalEnd < intervals.get(0).start){
            intervals.add(0, newInterval);
        }

        for(int i=0; i < intervals.size(); i++){
            int tempStart = intervals.get(i).start;
            int tempEnd = intervals.get(i).end;
            if( tempStart <= newIntervalStart && newIntervalStart <= tempEnd){
                mergedStart = tempStart;
                isStartAssigned = true;
            }else if(newIntervalStart < tempStart && !isStartAssigned){
                mergedStart = newIntervalStart;
                isStartAssigned = true;
            }

            if( tempStart <= newIntervalEnd && newIntervalEnd <= tempEnd){
                mergedEnd = tempEnd;
                mergedIntervals.add(new Interval(mergedStart, mergedEnd));
                if(i +1 < intervals.size()){
                    mergedIntervals.addAll(intervals.subList(i+1, intervals.size()));
                }
                return mergedIntervals;
            }else if(newIntervalEnd < tempStart){
                mergedEnd = newIntervalEnd;
                mergedIntervals.add(new Interval(mergedStart, mergedEnd));
                if(i < intervals.size()){
                    mergedIntervals.addAll(intervals.subList(i, intervals.size()));
                }
                return mergedIntervals;
            }

            if(!isStartAssigned){
                mergedIntervals.add(intervals.get(i));
            }
        }

        mergedIntervals.add(new Interval(mergedStart, newInterval.end));
        return mergedIntervals;
    }



    public List<Interval> insertQuick(List<Interval> intervals, Interval newInterval) {


        /*1. Find all intervals whose end is smaller than new interval
        * 2. Find all intervals whose start is larger than new interval */


        //!!!!!!!!!;ppppppll
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }

}














class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }