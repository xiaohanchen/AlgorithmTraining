package com.xiaohan;

import java.util.*;

public class MergeIntervals {


    public static void main(String[] args) {
        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(5,9);
        Interval i3 = new Interval(3,5);
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(Arrays.asList(i1,i2,i3));
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
}


class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }