package comorgsminorproj.httpsgithub.jobber;

import java.util.ArrayList;

/**
 * Created by nancymalik on 25/11/17.
 */

public class Find {

    ArrayList<String> loc;
    ArrayList<String> desig;
    ArrayList<String> type;
    String qualification;

    public Find(ArrayList<String> loc, ArrayList<String> desig, ArrayList<String> type, String qualification) {
        this.loc = loc;
        this.desig = desig;
        this.type = type;
        this.qualification = qualification;
    }

    public ArrayList<String> getLoc() {
        return loc;
    }

    public ArrayList<String> getDesig() {
        return desig;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public String getQualification() {
        return qualification;
    }
}
