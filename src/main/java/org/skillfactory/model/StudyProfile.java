package org.skillfactory.model;

public enum StudyProfile {
    MEDICINE ("Медицина"),
    PHYSICS ("Физика"),
    LINGUISTICS ("Лингвистика"),
    MATHEMATICS ("Математика"),
    RADIOTHECH ("Радиотехника");
    private String name;
    StudyProfile(String name) {
       this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
