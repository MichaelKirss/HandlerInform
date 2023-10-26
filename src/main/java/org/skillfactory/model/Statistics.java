package org.skillfactory.model;

public class Statistics {
    private StudyProfile profile;
    private float averageScore;
    private int countStudentsProfile;
    private int countUniversityProfile;
    private String nameUniversity;

    public Statistics(StudyProfile profile, float averageScore, int countStudentsProfile, int countUniversityProfile, String nameUniversity) {
        this.profile = profile;
        this.averageScore = averageScore;
        this.countStudentsProfile = countStudentsProfile;
        this.countUniversityProfile = countUniversityProfile;
        this.nameUniversity = nameUniversity;
    }

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

}
