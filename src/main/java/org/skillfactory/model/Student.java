package org.skillfactory.model;

public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student(String fullName, String  universityId, int currentCourseNumber,float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
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
      return  "Класс  " + getClass().getSimpleName() +  "\n"  +
              "Полное имя   " +this.fullName +"\n"+
              "Университет  " + this.universityId + "\n"+
              "Курс  " +this.currentCourseNumber+ "\n"+
              "Средний балл  "+this.avgExamScore+ "\n";
    }
}

