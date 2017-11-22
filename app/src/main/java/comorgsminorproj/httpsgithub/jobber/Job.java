package comorgsminorproj.httpsgithub.jobber;

import java.util.ArrayList;

/**
 * Created by MK on 22-11-2017.
 */

public class Job {

    String desg;
    String type;
    String salary;
    ArrayList<String> loc;

    public Job(String desg, String type, String salary, ArrayList<String> loc) {
        this.desg = desg;
        this.type = type;
        this.salary = salary;
        this.loc = loc;
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
}
