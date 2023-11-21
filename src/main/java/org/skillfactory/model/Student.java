package org.skillfactory.model;

import com.google.gson.annotations.SerializedName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "StudentInfo")
public class Student {
    @SerializedName("fullStudentName")
    @Element(name = "fullStudentName")
    private String fullName;
    @SerializedName("universityId")
    @Element(name ="universityId")
    private String universityId;
    @SerializedName("courseNumber")
    @Element(name ="courseNumber")
    private int currentCourseNumber;
    @SerializedName("averageScore")
    @Element(name = "averageScore")
    private float avgExamScore;

    public Student(String fullName, String  universityId, int currentCourseNumber,float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }
    public Student(){

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }
    @Override
    public String toString(){
      return  "\n" + "Студент"  +  "\n"  +
              "Полное имя   " +this.fullName +"\n"+
              "Идентификатор университета  " + this.universityId + "\n"+
              "Курс  " +this.currentCourseNumber+ "\n"+
              "Средний балл  "+this.avgExamScore+ "\n";
    }
}

