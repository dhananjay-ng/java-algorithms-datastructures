package problems.onsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnowYourLibrary {

    static class Student implements Comparable<Student> {
        String name ;
        double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public int compareTo(Student student) {
          return  this.name.compareTo(student.name);
        }

        public static void sortByGpa(List<Student> studentList) {
            Collections.sort(studentList, Collections.reverseOrder(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o1.gpa, o2.gpa);
                }
            }));
        }

        @Override
        public String toString() {
            return "Name : "+ this.name+"   "+"GPA :"+" "+this.gpa;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("AAA", 3.1d);
        Student student2 = new Student("BBB", 4.1d);;
        Student student3 = new Student("CCC", 4.5d);;
        Student student4 = new Student("DDD", 5.0d);;
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        Collections.sort(students);
        students.forEach(System.out::println);
        Student.sortByGpa(students);
        System.out.println("\n");
        students.forEach(System.out::println);


    }

}
