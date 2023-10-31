package org.skillfactory.external;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.skillfactory.model.Statistics;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import static org.skillfactory.utilites.Settings.*;

public class ExcelWriter {
    private static XSSFCellStyle title;
    private static XSSFCellStyle common;
    private static XSSFWorkbook excelFile;
    private static XSSFSheet sheet;

    private static void setStyleBegin(){
        excelFile = new XSSFWorkbook(XSSFWorkbookType .XLSX);
        sheet = excelFile.createSheet(OUTPUT_SHEET_NAME);
        for(int i = 0; i < COLUMN_WIDTH.length; i++){
            sheet.setColumnWidth(i, COLUMN_WIDTH[i]);
        }
        title = excelFile.createCellStyle();
        title.setFont(styleFont(excelFile,true,HEIGHT_FONT_HEADER ));
        title.setAlignment(HorizontalAlignment.CENTER);
        common = excelFile.createCellStyle();
        common.setAlignment(HorizontalAlignment.RIGHT);
        common.setFont(styleFont(excelFile,false, HEIGHT_FONT_DEFAULT));

    }

    private static XSSFFont styleFont(XSSFWorkbook nameFile,
                                      boolean typeFont,
                                      short fontHeight){
        XSSFFont font = nameFile.createFont();
        font.setFontHeightInPoints(fontHeight);
        font.setBold(typeFont);
        font.setFontName(FONT_NAME);
        return(font);
    }

    public static XSSFWorkbook tableGenerate (ArrayList<Statistics> data) throws IOException {
        setStyleBegin();
        //заголовок таблицы
        XSSFRow row = sheet.createRow(0);
        for (int i =0; i<TITLE_SHEET_STATISTICS.length; i++){
            XSSFCell cell = row.createCell(i, CellType.STRING);
            cell.setCellStyle(title);
            cell.setCellValue(TITLE_SHEET_STATISTICS[i]);
        }
        //шаблон стилей строк
        XSSFRow templateRow;
        XSSFCell templateCell;
        String str = "";
        float fNum;
        int iNum;
        for (int i =0; i < data.size(); i++){
            templateRow = sheet.createRow(i+1);
            templateCell = templateRow.createCell(0, CellType.STRING);
            templateCell.setCellStyle(common);
            str = String.valueOf(data.get(i).getProfile());
            templateCell.setCellValue(str);
            templateCell = templateRow.createCell(1, CellType.NUMERIC);
            templateCell.setCellStyle(common);
            fNum = data.get(i).getAverageScore();
            templateCell.setCellValue(fNum);
            templateCell = templateRow.createCell(2, CellType.NUMERIC);
            templateCell.setCellStyle(common);
            iNum = data.get(i).getCountStudentsProfile();
            templateCell.setCellValue(iNum);
            templateCell = templateRow.createCell(3, CellType.NUMERIC);
            templateCell.setCellStyle(common);
            iNum = data.get(i).getCountUniversityProfile();
            templateCell.setCellValue(iNum);
            templateCell = templateRow.createCell(4, CellType.STRING);
            templateCell.setCellStyle(common);
            str = data.get(i).getNameUniversity();
            templateCell.setCellValue(str);
        }
        return excelFile;
    }
    public static void writeFile (XSSFWorkbook name, String fullNameFile){
        try{
            name.write(new FileOutputStream(fullNameFile));
            name.close();
        }catch(FileNotFoundException e) {
            throw new RuntimeException(e);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
