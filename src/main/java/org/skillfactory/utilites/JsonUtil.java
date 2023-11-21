package org.skillfactory.utilites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class JsonUtil {
    private JsonUtil(){}
    private static final Logger log = Logger.getLogger(JsonUtil.class.getName());
    public static String  serialToJs (ArrayList <?> list){
        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        String js = gs.toJson(list);
        log.log(INFO, "Parsing to JSON " );
        return js;
    }
    public static ArrayList <?> desJsToList (String nameJson){
        Gson gson = new GsonBuilder().create();
        Type collectionType = new TypeToken<ArrayList<?>>(){}.getType();
        ArrayList<?> l  = gson.fromJson(nameJson, collectionType);
        log.log(INFO, "JSON deserialization class to Array ");
        return l;
    }



}
