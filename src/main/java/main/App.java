package main;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
   
    public static void main( String[] args )
    {
        
        Scanner sc = new Scanner(System.in);
        University newUniversity = new University();

        boolean exit = false;
        while(!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                    System.out.println("Anna opiskelijan nimi?");
                    String name = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    int studentNumber = Integer.parseInt(sc.nextLine());

                    Student newStudent = new Student(name, studentNumber);
                    newUniversity.addStudent(newStudent);
                    // newUniversity.writeLog(newStudent.getName());
                    break;

                    case 2:
                    newUniversity.printStudents();
                    break;

                    case 3:
                    List<Student> students = newUniversity.getStudents();

                    for (int j = 0; j < students.size(); j++) {
                        System.out.println(j +": "+ students.get(j).getName());
                    }


                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    int studentPosition = Integer.parseInt(sc.nextLine());
                    System.out.println("Mille kurssille suorite lisätään?");
                    String course = sc.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    int grade = Integer.parseInt(sc.nextLine());

                    students.get(studentPosition).addGrade(course, grade);
                    break;

                    case 4:
                    List<Student> students2 = newUniversity.getStudents();

                    for (int j = 0; j < students2.size(); j++) {
                        System.out.println(j +": "+ students2.get(j).getName());
                    }
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    int studentPosition2 = Integer.parseInt(sc.nextLine());
                    students2.get(studentPosition2).printGrades();
                    break;

                    case 5:
                    // ota lista opiskelijoista
                    List<Student> students3 = newUniversity.getStudents();

                    // alusta laskin
                    Calculator cal = new Calculator();

                    // käy opiskelijalista läpi ja printtaa niiden nimi
                    for (int j = 0; j < students3.size(); j++) {
                        System.out.println(j +": "+ students3.get(j).getName());
                    }

                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    // tallenna käyttäjän valinta int muuttujaan
                    int studentPosition3 = Integer.parseInt(sc.nextLine());

                    // valitse opiskelijalistasta opiskelija käyttäjän antamasta positiosta
                    Student student3 = students3.get(studentPosition3);

                    // välitä laskimelle käyttäjän valitsema opiskelija ja tallenna palautuva arvo muuttujaan
                    double average = cal.getAverageGrade(student3);
                    System.out.println("Keskiarvo on " + average);
                    break;

                    case 6:
                    List<Student> students4 = newUniversity.getStudents();

                    Calculator calculator = new Calculator();

                    for (int j = 0; j < students4.size(); j++) {
                        System.out.println(j +": "+ students4.get(j).getName());
                    }

                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    int studentPosition4 = Integer.parseInt(sc.nextLine());
                    Student student4 = students4.get(studentPosition4);

                    double median = calculator.getMedianGrade(student4);
                    System.out.println("Mediaani on " + median);
                    break;

                    case 7:
                    List<Student> students5 = newUniversity.getStudents();

                    students5.forEach((student) -> {
                        newUniversity.writeLog(student.getName() + ": " + student.getStudentNumber());
                    });
                    break;

                    case 8:
                    newUniversity.readLog();
                    break;

                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }            
       }
    }
    sc.close();
}}

