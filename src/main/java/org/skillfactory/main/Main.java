package org.skillfactory.main;

import org.skillfactory.model.Student;
import org.skillfactory.model.StudyProfile;
import org.skillfactory.model.University;

public class Main {

    public static void main(String[] args) {
        Student st = new Student("Micke","Tech", 4, 4.339f);
        University uni = new University("1f2", "Московский медицинский институт", "ММИ", 1990, StudyProfile.MEDICINE);

        System.out.println(st);
        System.out.println(uni);
    }
}