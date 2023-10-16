package org.skillfactory.main;

import org.skillfactory.comparators.StudentComparator;
import org.skillfactory.comparators.UniversityComparator;
import org.skillfactory.comparators.choice.ChoiceTypeComparator;
import org.skillfactory.comparators.enums.StudentComparators;
import org.skillfactory.comparators.enums.UniversityComparators;
import org.skillfactory.model.Student;
import org.skillfactory.model.University;

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
        System.out.println("Сериализация JSON");
        System.out.println("Университеты");
        u.stream().sorted(universityComparator).forEach(System.out::println);
        System.out.println("Студенты");
        s.stream().sorted(studentComparator).forEach(System.out::println);
        String jsonStudent = serialToJsStudent(s);
        System.out.println(jsonStudent);
        String jsonUniversity = serialToJsUniversity(u);
        System.out.println("Десериализация JSON");
        System.out.println(jsonUniversity);
        ArrayList <Student> ls = new ArrayList<>();
        ArrayList <University> lu = new ArrayList<>();
        ls = desStudentJsToList(jsonStudent);
        lu = desUniversityJsToList(jsonUniversity);
        System.out.println(ls);
        System.out.println(lu);
        System.out.println("Сравнение по количеству Унимверситеты");
        System.out.println(u.stream().count() + "   До десериализации");
        System.out.println(lu.stream().count() + "   После десериализации");
        System.out.println();
        System.out.println("Сравнение по количеству Студенты");
        System.out.println(s.stream().count() + "   До десериализации");
        System.out.println(ls.stream().count() + "   После десериализации");
    }

}
