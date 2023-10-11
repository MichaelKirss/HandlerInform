package org.skillfactory.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.skillfactory.comparators.StudentComparator;
import org.skillfactory.comparators.UniversityComparator;
import org.skillfactory.comparators.choice.ChoiceTypeComparator;
import org.skillfactory.comparators.enums.StudentComparators;
import org.skillfactory.comparators.enums.UniversityComparators;
import org.skillfactory.model.Student;
import org.skillfactory.model.University;
import org.skillfactory.utilites.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;

import static org.skillfactory.load.ExcelLoader.parserStudent;
import static org.skillfactory.load.ExcelLoader.parserUniversity;
import static org.skillfactory.utilites.JsonUtil.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile ="src/main/resources/universityinfo.xlsx";
        ArrayList<Student> s =(ArrayList<Student>) parserStudent(nameFile);
        ArrayList<University> u = (ArrayList<University>) parserUniversity(nameFile);
        UniversityComparator universityComparator =
        ChoiceTypeComparator.UniversitysComparatorsChoice(UniversityComparators.YEAR);
        StudentComparator studentComparator =
        ChoiceTypeComparator.StudentsComparatorsChoice(StudentComparators.AVG_EXAM_SCORE);
//        System.out.println("Университеты");
//        u.stream().sorted(universityComparator).forEach(System.out::println);
//        System.out.println("Студенты");
//        s.stream().sorted(studentComparator).forEach(System.out::println);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String sJs = gson.toJson(s);
        System.out.println(sJs);

    }

}
