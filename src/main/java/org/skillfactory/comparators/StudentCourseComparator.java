package org.skillfactory.comparators;

import org.skillfactory.model.Student;

public class StudentCourseComparator implements StudentComparator {
    @Override
    public int compare(Student v1, Student v2) {
        return Integer.compare(v1.getCurrentCourseNumber(), v2.getCurrentCourseNumber());
    }
}
