package org.skillfactory.external;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skillfactory.model.*;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;


public class ExcelLoader {
    public static ArrayList<Student> students;
    public static ArrayList<University> universities;
    public static final String uniSheet = "Университеты";
    public static final String stdSheet = "Студенты";
    public static XSSFSheet tmpSheet;

    private ExcelLoader() {}

    private static final Logger log = Logger.getLogger(ExcelLoader.class.getName());

    public static void loadFile (String file, String nameSheet) throws IOException {
        try {
            XSSFWorkbook sheets = new XSSFWorkbook(new FileInputStream(file));
            tmpSheet = sheets.getSheet(nameSheet);
            log.log(INFO, "Excel file now Loaded");
        } catch (IOException e){
            log.log(SEVERE, "Excel file not found " + e.toString());
        }
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





