package org.skillfactory.main;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skillfactory.comparators.*;
import org.skillfactory.comparators.choice.ChoiceTypeComparator;
import org.skillfactory.comparators.enums.*;
import org.skillfactory.external.ExcelWriter;
import org.skillfactory.model.Statistics;
import org.skillfactory.model.*;
import java.util.logging.*;
import java.io.IOException;
import java.util.ArrayList;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static org.skillfactory.external.ExcelLoader.parserStudent;
import static org.skillfactory.external.ExcelLoader.parserUniversity;
import static org.skillfactory.utilites.Settings.*;
import static org.skillfactory.utilites.StatisticsCount.countyStat;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException, NullPointerException   {
         try {
               LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties")
                                                            );
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        } catch (NullPointerException e) {
             System.err.println("Could not find configuration file:  " + e.toString());
         }
        log.log(INFO, "Logger configuration is complete, Application started");

        String nameFile = PATH_FILES + INPUT_NAME_FILE;
        ArrayList<Student> s = new ArrayList<>();
        ArrayList<University> u = new ArrayList<>();
        try {
            s = (ArrayList<Student>) parserStudent(nameFile);
            u = (ArrayList<University>) parserUniversity(nameFile);
            UniversityComparator universityComparator =
                    ChoiceTypeComparator.UniversitysComparatorsChoice(UniversityComparators.YEAR);
            log.log(INFO, "List Universitys is sorted");
            StudentComparator studentComparator =
                    ChoiceTypeComparator.StudentsComparatorsChoice(StudentComparators.AVG_EXAM_SCORE);
            log.log(INFO, "List Students is sorted");
        }catch(NullPointerException e){
            log.log(SEVERE, "Excel file not found " + e.toString());
        }
        String nf = PATH_FILES + OUTPUT_NAME_FILE;

        ArrayList<Statistics> listStat = new ArrayList<>();
        listStat = countyStat(s, u);
        XSSFWorkbook book = ExcelWriter.tableGenerate(listStat);
        ExcelWriter.writeFile(book,nf);
        log.log(INFO, "Application finished");
    }
}
