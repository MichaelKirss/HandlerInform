package org.skillfactory.model;

import com.google.gson.annotations.SerializedName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "UniversityInfo")
public class University {
    @SerializedName("universityId")
    @Element(name = "universityId")
    private String id;
    @SerializedName("fullUniversityName")
    @Element(name ="fullUniversityName")
    private String fullName;
    @SerializedName("shortUniversityName")
    @Element(name ="shortUniversityName")
    private String shortName;

    @SerializedName("yearFoundation")
    @Element(name ="yearFoundation")
    private int yearOfFoundation;
    @SerializedName("mainProfile")
    @Element(name ="mainProfile")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }
    public University(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }
    @Override
    public String toString(){
        return  "\n"  +"Университет" +  "\n"  +
                "Идентификатор   " +this.id +"\n"+
                "Полное наименование университета  " + this.fullName + "\n"+
                "Короткое наименование университета  " + this.shortName + "\n"+
                "Год основания  " +this.yearOfFoundation+ "\n"+
                "Специализация университета  "+this.mainProfile+ "\n";
    }
}
