package org.skillfactory.main;

import org.skillfactory.model.Student;
import org.skillfactory.model.University;

import java.io.IOException;
import java.util.ArrayList;


import static org.skillfactory.load.ExcelLoader.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile ="src/main/resources/universityinfo.xlsx";
        ArrayList<Student> s =(ArrayList<Student>) parserStudent(nameFile);
        ArrayList<University> u = (ArrayList<University>) parserUniversity(nameFile);
        System.out.println("Список студентов");
        System.out.println(s.toString());
        System.out.println("Список Университетов");
        System.out.println(u.toString());
    }

}
