package org.skillfactory.model;



import com.google.gson.annotations.SerializedName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Date;

@Root(name = "payload")

public class CollectorData {
    @ElementList(name = "Students")
    @SerializedName("Students")
    private ArrayList<Student> studentList;
    @ElementList(name = "Universities")
    @SerializedName("Universities")
    private ArrayList<University> universityList;
    @ElementList(name = "Statistics")
    @SerializedName("Statistics")
    private ArrayList<Statistics> statisticsList;
    @Element(name = "processedDate")
    @SerializedName("ProcessedDate")
    private Date processDate;
    public CollectorData() {}

    public CollectorData setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public CollectorData setUniversityList(ArrayList<University> universityList) {
        this.universityList = universityList;
        return this;

    }

    public CollectorData setStatisticsList(ArrayList<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public CollectorData setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<University> getUniversityList() {
        return universityList;
    }

    public ArrayList<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public Date getProcessDate() {
        return processDate;
    }
}
