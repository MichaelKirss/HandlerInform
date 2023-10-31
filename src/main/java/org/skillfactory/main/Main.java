package org.skillfactory.main;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skillfactory.external.ExcelWriter;
import org.skillfactory.model.Statistics;
import org.skillfactory.model.StudyProfile;

import java.io.IOException;
import java.util.ArrayList;

import static org.skillfactory.utilites.Settings.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile = PATH_OUTPUT + OUTPUT_NAME_FILE;
        ArrayList<Statistics> listStat = new ArrayList<>();
        listStat.add(new Statistics(StudyProfile.MEDICINE,
                1.55F, 4, 3,
                "Университет"));
        XSSFWorkbook book = ExcelWriter.tableGenerate(listStat);
        ExcelWriter.writeFile(book,nameFile);
    }
}
