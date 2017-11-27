package comorgsminorproj.httpsgithub.jobber;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MK on 26-11-2017.
 */
@IgnoreExtraProperties
public class JobSource {
    @SerializedName("_source")
    @Expose
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
