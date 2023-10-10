package org.skillfactory.comparators.choice;

import org.skillfactory.comparators.*;
import org.skillfactory.comparators.enums.StudentComparators;
import org.skillfactory.comparators.enums.UniversityComparators;

public class ChoiceTypeComparator {
    private ChoiceTypeComparator(){}
    public static StudentComparator StudentsComparatorsChoice(StudentComparators typeComparator){
        switch(typeComparator){
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentAverageScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }
    public static UniversityComparator UniversitysComparatorsChoice(UniversityComparators typeComparator){
        switch(typeComparator){
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case YEAR:
                return new UniversityYearOfFoundationComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
