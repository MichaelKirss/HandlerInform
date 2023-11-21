package org.skillfactory.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name ="StatisticsInfo")
public class Statistics {
    @Element(name = "Profile")
    private StudyProfile profile;
    @Element(name ="AverageScore")
    private float averageScore;
    @Element(name = "CountStudentsProfile")
    private int countStudentsProfile;
    @Element(name="CountUniversityPrifile")
    private int countUniversityProfile;
    @Element(name = "NameUniversity")
    private String nameUniversity;
    @Element(name="AverageScoreStat")
    private String averageScoreString;


    public Statistics(StudyProfile profile, float averageScore, int countStudentsProfile, int countUniversityProfile, String nameUniversity) {
        this.profile = profile;
        this.averageScore = averageScore;
        this.countStudentsProfile = countStudentsProfile;
        this.countUniversityProfile = countUniversityProfile;
        this.nameUniversity = nameUniversity;
    }

    public Statistics() { }

    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public int getCountStudentsProfile() {
        return countStudentsProfile;
    }

    public void setCountStudentsProfile(int countStudentsProfile) {
        this.countStudentsProfile = countStudentsProfile;
    }

    public int getCountUniversityProfile() {
        return countUniversityProfile;
    }

    public void setCountUniversityProfile(int countUniversityProfile) {
        this.countUniversityProfile = countUniversityProfile;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public String getAverageScoreString() {
        return averageScoreString;
    }

    public void setAverageScoreString(String averageScoreString) {
        this.averageScoreString = averageScoreString;
    }
}
