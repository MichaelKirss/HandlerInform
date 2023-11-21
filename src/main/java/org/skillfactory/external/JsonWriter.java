package org.skillfactory.external;

import org.skillfactory.model.CollectorData;
import org.skillfactory.utilites.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.skillfactory.utilites.Settings.NAME_EXPORT_JSON;
import static org.skillfactory.utilites.Settings.PATH_EXPORT_JSON;

public class JsonWriter {
    private static final Logger log = Logger.getLogger(JsonWriter.class.getName());
    private static String exportJsonPath = PATH_EXPORT_JSON;
    private static String exportJsonFileName = NAME_EXPORT_JSON;

    public static void writeJsonReq(CollectorData totalData) {

        log.log(Level.INFO, "JSON creation started");

        try {
            Files.createDirectory(Paths.get(exportJsonPath));
            log.log(Level.INFO, "Directory created successfully");
        } catch (IOException ioEx) {
            log.log(Level.FINE, "Directory already created", ioEx);
        }
       String result = JsonUtil.serialToJs(fileOutputJson(totalData));
        try {
            FileOutputStream outputStream =
                    new FileOutputStream(exportJsonPath +"/"+exportJsonFileName + totalData.getProcessDate().getTime() + ".json");
            outputStream.write(result.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
            log.log(Level.SEVERE, "JSON writing failed", e);
        }
            log.log(Level.INFO, "JSON writing finished successfully");
    }
    private static ArrayList fileOutputJson(CollectorData allData){
        List <Object> total = new ArrayList<>();
        total.add(allData);
        return (ArrayList) total;
    }

}
