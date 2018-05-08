package Draft;

import java.util.*;

public class JavaCollectionSort {

    static class Student{
        int score;
        Student(int score){ this.score = score;}
    }


    public static void main(String[] args) {
        Student student1 = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        Student student4 = new Student(4);
        Student student5 = new Student(5);
        Student student6 = new Student(6);
        Student student7 = new Student(7);
        List<Student> students = Arrays.asList(
                student1,
                student5,
                student3,
                student4,
                student2,
                student6,
                student7,
                student1);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.score < o2.score ? -1 : (o1.score == o2.score ? 0 : 1);
            }
        });

        return;
    }
}
