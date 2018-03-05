package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {
    private String name;
    private int age;
    private List<Student> students=new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        Student newStudent = null;
        for (Student student : getStudents()) {
            if (student.getAverageGrade() == value)
                newStudent = student;
        }
        return newStudent;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student goodStudent = students.get(0);
        for (Student student : students) {
            if (student.getAverageGrade() > goodStudent.getAverageGrade())
                goodStudent = student;
        }
        return goodStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        Student badStudent = students.get(0);
        for (Student student : students) {
            if (student.getAverageGrade() < badStudent.getAverageGrade())
                badStudent = student;
        }
        return badStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}