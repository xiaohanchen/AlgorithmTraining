package com.xiaohan;

import java.util.*;

public class ComparatorPractise {


    public static void main(String[] args) {


        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>();
        sortedQueue.add(3);
        sortedQueue.add(2);
        sortedQueue.add(1);
        sortedQueue.add(4);
        Main.print(sortedQueue);

        List<Student> studentArrays = new ArrayList<>();
        studentArrays.add(new Student(2,"b", 20));
        studentArrays.add(new Student(1,"a", 10));
        studentArrays.add(new Student(3,"c", 30));


        //WITHOUT CREATING A NEW CLASS TO IMPLEMENT COMPARATOR
        Collections.sort(studentArrays, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age > o2.age){
                    return 1;
                }else if(o1.age < o2.age){
                    return -1;
                }else{
                    return 0;
                }
            }
        });


        Main.print(studentArrays.get(0).name);
        Main.print(studentArrays.get(1).name);
        Main.print(studentArrays.get(2).name);

    }
}



//CREATE NEW CLASS TO IMPLEMENT THE COMPARATOR
class AgeComparator implements Comparator {

    public int compare(Object o1,Object o2){
        Student s1=(Student)o1; //notice here....
        Student s2=(Student)o2;

        if(s1.age==s2.age)
            return 0;
        else if(s1.age>s2.age)
            return 1;
        else
            return -1;
    }
}


class Student{
    int rollno;
    String name;
    int age;
    Student(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }
}