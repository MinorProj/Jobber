package comorgsminorproj.httpsgithub.jobber;

/**
 * Created by MK on 18-11-2017.
 */

public class Rprofile {

    private String recruiter;
    private String raddress;
    private String rphone;
    private String remail;
    private String rname;
    private String rpassword;

    public Rprofile(String recruiter, String raddress, String rphone, String remail, String rname, String rpassword) {
        this.recruiter = recruiter;
        this.raddress = raddress;
        this.rphone = rphone;
        this.remail = remail;
        this.rname = rname;
        this.rpassword = rpassword;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public String getRaddress() {
        return raddress;
    }

    public String getRphone() {
        return rphone;
    }

    public String getRemail() {
        return remail;
    }

    public String getRname() {
        return rname;
    }
}
