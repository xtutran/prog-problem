package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 *
 * Sort a list of student by grade
 *
 */

class Student {
    private String name;
    private int age;
    private double grade;

    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + ":" + age + ":" + grade;
    }

    String getName() { return name; }
    int getAge() { return age; }
    double getGrade() { return grade; }

}

public class Problem4 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("John1", 23, 6.5));
        students.add(new Student("John2", 23, 5.5));
        students.add(new Student("John3", 23, 5.0));
        students.add(new Student("John4", 23, 5.0));
        students.add(new Student("John5", 23, 7.5));
        students.add(new Student("John6", 23, 9.5));

        students.sort(Comparator.comparingDouble(Student::getGrade));
        students.forEach(System.out::println);
    }

}
