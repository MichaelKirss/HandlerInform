package org.skillfactory.load;

public enum WorkSheet {
    UNIVERSITY ("Университеты"),
    STUDENTS ("Студенты");

    WorkSheet(String name) {
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }
}
