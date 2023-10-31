package org.skillfactory.utilites;

public abstract class Settings {
public static final int[] COLUMN_WIDTH = new int[]{6000,7000,7000,8000,7000};
public static final float DEFAULT_ROW_WIDTH = 15F;
public static final float MAX_ROW_WIDTH = 30F;
public static final String FONT_NAME = "Arial";
public static final String OUTPUT_SHEET_NAME = "Статистика";
public static final String OUTPUT_NAME_FILE ="Statistics.xlsx" ;
public static final String PATH_OUTPUT ="src/main/resources/" ;
public static final short HEIGHT_FONT_HEADER = 12;
public static final short HEIGHT_FONT_DEFAULT = 10;
public static final String[] TITLE_SHEET_STATISTICS = new String[]
        {
            "Профиль обучения",
            "Средний балл экзамена",
            "Количество студентов",
            "Количество университетов",
            "Название университета"
        };

private Settings(){}
}
