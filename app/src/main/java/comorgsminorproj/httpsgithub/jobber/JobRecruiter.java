package comorgsminorproj.httpsgithub.jobber;

/**
 * Created by MK on 24-11-2017.
 */

public class JobRecruiter {

    private String job;
    private String recruiter;

    public JobRecruiter(String job, String recruiter) {
        this.job = job;
        this.recruiter = recruiter;
    }

    public String getJob() {
        return job;
    }

    public String getRecruiter() {
        return recruiter;
    }
}
