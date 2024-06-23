package main;

public class Grade {
    private String course;
    private int grade;
    public Grade(String course, int grade) {
        this.course = course;
        this.grade = grade;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void printSpecs() {
        System.out.println(course + ": " + grade);

    }
}