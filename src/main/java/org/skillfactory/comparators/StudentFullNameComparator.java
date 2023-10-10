package org.skillfactory.comparators;

import org.apache.commons.lang3.StringUtils;
import org.skillfactory.model.Student;


public class StudentFullNameComparator implements StudentComparator{
    @Override
    public int compare(Student v1, Student v2) {
        return StringUtils.compare(v1.getFullName(), v2.getFullName());
    }
}
