package org.skillfactory.comparators;

import org.skillfactory.model.Student;

public class StudentAverageScoreComparator implements StudentComparator{
    @Override
    public int compare(Student v1, Student v2) {
        return Float.compare(v2.getAvgExamScore(), v1.getAvgExamScore());
    }
}
