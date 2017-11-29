package comorgsminorproj.httpsgithub.jobber;

import java.util.ArrayList;

/**
 * Created by MK on 22-11-2017.
 */

public class Job {

     String jobID;
     String desg;
     String type;
     String salary;
     String qualification;
     ArrayList<String> loc;

    public  Job(){}

    public Job(String jobID, String desg, String type, String salary, String qualification, ArrayList<String> loc) {
        this.jobID = jobID;
        this.desg = desg;
        this.type = type;
        this.salary = salary;
        this.loc = loc;
        this.qualification = qualification;
    }

    public String getJobID() {
        return jobID;
    }

    public String getDesg() {
        return desg;
    }

    public String getType() {
        return type;
    }

    public String getSalary() {
        return salary;
    }

    public ArrayList<String> getLoc() {
        return loc;
    }

    public String getQualification() {
        return qualification;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setLoc(ArrayList<String> loc) {
        this.loc = loc;
    }
}
