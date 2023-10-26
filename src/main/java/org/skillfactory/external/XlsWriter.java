package org.skillfactory.external;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skillfactory.model.Statistics;
import org.skillfactory.model.Student;
import org.skillfactory.model.University;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XlsWriter {
    static ArrayList<Student> students;
    static ArrayList<University> universities;
    static final String uniSheet = "Университеты";
    static final String stdSheet = "Студенты";
        static final String[] titleStatistics = new String[]{
                                                        "Профиль обучения",
                                                        "Средний балл экзамена",
                                                        "Количество студентов",
                                                        "Количество университетов",
                                                        "Название университета"
                                                            };
    static String fullNameFile;


    public static void createFile (String fullNameFile, ArrayList<Statistics> stat) throws IOException {
        XSSFWorkbook excelFile = new XSSFWorkbook(fullNameFile);
        XSSFSheet sheet1 = excelFile.createSheet(stdSheet);
        XSSFSheet sheet2 = excelFile.createSheet(uniSheet);


    }
}
