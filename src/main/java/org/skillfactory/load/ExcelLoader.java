package org.skillfactory.load;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skillfactory.model.*;


public class ExcelLoader {
    static ArrayList<Student> students;
    static ArrayList<University> universities;
    static final String uniSheet = "Университеты";
    static final String stdSheet = "Студенты";

    static XSSFSheet tmpSheet;

    private ExcelLoader() {}

    public static void loadFile (String file, String nameSheet) throws IOException {
        XSSFWorkbook sheets = new XSSFWorkbook(new FileInputStream(file));
        tmpSheet = sheets.getSheet(nameSheet);
    }

    public static List <Student> parserStudent (String file)throws IOException{
        loadFile(file,stdSheet);
        List<Student> students = new ArrayList<>();
        Iterator<Row> rows = tmpSheet.iterator();
            rows.next();
            while (rows.hasNext()){
                Row row = rows.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(row.getCell(0).getStringCellValue());
                student.setFullName(row.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int)row.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float)row.getCell(3).getNumericCellValue());
             }
            return students;
    }
    public static List <University> parserUniversity (String file) throws IOException{
        loadFile(file,uniSheet);
        List<University> universitys = new ArrayList<>();
        Iterator<Row> rows = tmpSheet.iterator();
        rows.next();
        while (rows.hasNext()){
            Row row = rows.next();
            University university = new University();
            universitys.add(university);
            university.setId(row.getCell(0).getStringCellValue());
            university.setFullName(row.getCell(1).getStringCellValue());
            university.setShortName(row.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)row.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, row.getCell(4).getStringCellValue()));
        }
        return universitys;
    }

}





