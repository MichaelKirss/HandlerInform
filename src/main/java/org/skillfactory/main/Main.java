package org.skillfactory.main;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skillfactory.comparators.*;
import org.skillfactory.comparators.choice.ChoiceTypeComparator;
import org.skillfactory.comparators.enums.*;
import org.skillfactory.external.ExcelWriter;
import org.skillfactory.model.Statistics;
import org.skillfactory.model.*;
import org.skillfactory.utilites.StatisticsCount;

import java.io.IOException;
import java.util.ArrayList;

import static java.util.stream.Collectors.counting;
import static org.skillfactory.external.ExcelLoader.parserStudent;
import static org.skillfactory.external.ExcelLoader.parserUniversity;
import static org.skillfactory.utilites.JsonUtil.*;
import static org.skillfactory.utilites.Settings.*;
import static org.skillfactory.utilites.StatisticsCount.countyStat;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile = PATH_FILES + INPUT_NAME_FILE;
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
        System.out.println("Сравнение по количеству Университеты");
        System.out.println("До сериализации -   "+ u.size()+"    После десериализации   "+ lu.size());
        System.out.println();
        System.out.println("Сравнение по количеству Студенты");
        System.out.println("До сериализации -   "+ s.size()+"    После десериализации   "+ ls.size());

        String nf = PATH_FILES + OUTPUT_NAME_FILE;
        ArrayList<Statistics> listStat = new ArrayList<>();
        listStat = countyStat(ls, lu);
        XSSFWorkbook book = ExcelWriter.tableGenerate(listStat);
        ExcelWriter.writeFile(book,nf);
    }
}
