package org.skillfactory.utilites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.skillfactory.model.Student;
import org.skillfactory.model.University;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtil {
    private JsonUtil(){}
    public static String  serialToJsStudent (ArrayList <Student> list){
        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        String js = gs.toJson(list);
        return js;
    }
    public static String  serialToJsUniversity (ArrayList <University> list){
        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        String js = gs.toJson(list);
        return js;
    }
    public static ArrayList <Student> desStudentJsToList (String student){
        Gson gson = new GsonBuilder().create();
        Type collectionType = new TypeToken<ArrayList<Student>>(){}.getType();
        ArrayList<Student> s  = gson.fromJson(student, collectionType);
        return s;
    }
    public static ArrayList <University> desUniversityJsToList (String university){
        Gson gson = new GsonBuilder().create();
        Type collectionType = new TypeToken<ArrayList<University>>(){}.getType();
        ArrayList<University> u  = gson.fromJson(university, collectionType);
        return u;
    }
}
