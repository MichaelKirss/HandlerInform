package org.skillfactory.external;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.skillfactory.model.CollectorData;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.skillfactory.utilites.Settings.*;

public class XmlWriter {
    private static final Logger log = Logger.getLogger(XmlWriter.class.getName());
    private static String exportXmlPath = PATH_EXPORT_XML;
    private static String exportXmlFileName = NAME_EXPORT_XML;
    public static void generateXmlReq(CollectorData totalData) throws Exception {
           try {
                Files.createDirectory(Paths.get(exportXmlPath));
                log.log(Level.INFO, "Directory created successfully");
            } catch (IOException ioEx) {
                log.log(Level.FINE, "Directory already created", ioEx);
            }
           File outputXmlFile = new File(
                        exportXmlPath+"/"+exportXmlFileName + new Date().getTime() + ".xml"
           );
            try{
                Serializer serializer = new Persister();
                serializer.write(totalData,outputXmlFile);

            }catch(Exception e){
                log.log(Level.SEVERE, "File xml not created   ", e);
            }
        log.log(Level.INFO, "XML creation finished successfully");
   }

}

