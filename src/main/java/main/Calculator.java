package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {
    

    public double getAverageGrade(Student s){
        List<Grade> gradesList = s.getGrades();
        double average;
        int totalGradeValue = 0;
        int amountOfGrades = gradesList.size();

        if (amountOfGrades == 0) {
            return 0;
        }

        for (int i = 0; i < gradesList.size(); i++) {
            totalGradeValue = totalGradeValue + gradesList.get(i).getGrade();
        }

        average = totalGradeValue / amountOfGrades;
        
        return average;
    }

    // https://javatutoring.com/java-calculate-median/
    public double getMedianGrade(Student s){
        List<Grade> gradesList = s.getGrades();
        double median;
        int amountOfGrades = gradesList.size();

        // lista kurssien arvosanoista
        List<Integer> gradeValueList = new ArrayList<>();

        // käy kurssi lista läpi ja lisää arvo kurssiArvosana listaan
        gradesList.forEach(grade -> {
            gradeValueList.add(grade.getGrade());
        });

        // järjestä kurssiArvosana lista nousevaan järjestykseen
        Collections.sort(gradeValueList);

        // tarkista onko listassa pariton vai parillinen määrä arvoja
        if(amountOfGrades % 2 == 1){
            int medianPosition = (amountOfGrades+1)/2-1;
            median = gradeValueList.get(medianPosition);
        }else {
            int medianPosition1 = amountOfGrades/2-1;
            int medianPosition2 = amountOfGrades/2;
            medianPosition1 = medianPosition1 < 0 ? 0 : medianPosition1;
            median = (double) (gradeValueList.get(medianPosition1) + gradeValueList.get(medianPosition2)) /2;
            // m=(a[n/2-1]+a[n/2])/2;   javatutoring.com
        }

        return median;
    }
}
