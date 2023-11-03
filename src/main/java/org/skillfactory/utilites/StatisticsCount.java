package org.skillfactory.utilites;

import org.apache.commons.lang3.StringUtils;
import org.skillfactory.model.Statistics;
import org.skillfactory.model.Student;
import org.skillfactory.model.StudyProfile;
import org.skillfactory.model.University;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.skillfactory.external.ExcelLoader.universities;

public class StatisticsCount {




    private StatisticsCount(){}

    public static ArrayList<Statistics> countyStat (ArrayList<Student> students,
                                             ArrayList<University> universities){
        ArrayList<Statistics> result =new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            result.add(statistics);
            statistics.setProfile(profile);
            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setCountUniversityProfile(profileUniversityIds.size());
            statistics.setNameUniversity(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setNameUniversity(
                            statistics.getNameUniversity() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setCountStudentsProfile(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAverageScore(0);
            avgExamScore.ifPresent(value -> statistics.setAverageScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_EVEN).doubleValue()));
            // На линуксе LibreOffise Calc если число с дрробной частью
            //округрение игнорировалось, пришлось преобразовывать в строку
            //после округления
            Float valF = statistics.getAverageScore();
            statistics.setAverageScoreString(valF.toString());
        });
        return  result;

    }
}
