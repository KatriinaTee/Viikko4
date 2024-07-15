package main;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class University {
    private ArrayList<Student> students;
    final private String FILENAME;

    public University() {
        this.students = new ArrayList<>();
        FILENAME = "log.txt";
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void printStudents (){
        System.out.println("opiskelijat: ");
        students.forEach((student) -> {
            student.printSpecs();
        });
    }
    
    public void writeLog(String logText){
        
        try {
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(FILENAME, true));
            logWriter.write(logText + "\n");
            logWriter.close();
            //System.out.println("Logimerkintä kirjattu.");
        } catch (IOException e) {
            //System.out.println("Virhe kirjoitettaessa logitiedostoa.");
            e.printStackTrace();
        }

    }
    public void readLog(){
        try {
            BufferedReader logReader = new BufferedReader(new FileReader(FILENAME));
            String line;
            while ((line = logReader.readLine()) != null){
                System.out.println(line);
                String[] s = line.split(":");
                Student newStudent = new Student(s[0], Integer.parseInt(s[1].trim()));
                addStudent(newStudent);
            }
            logReader.close();
        } catch (IOException e) {
            //System.out.println("Virhe luettaessa logitiedostoa.");
            e.printStackTrace();
        }
    }
}





