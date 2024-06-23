package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
    private String name;
    private int studentNumber;
    private ArrayList<Grade> grades;

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void addGrade(String course, int grade) {
        Grade gr = new Grade(course, grade);
        grades.add(gr);
    
    }

    public void printSpecs() {
        System.out.println(studentNumber + ": " + name);

    }
    public void printGrades() {
        grades.forEach((grade) -> {
            grade.printSpecs();
        });
    }
}
