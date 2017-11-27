package comorgsminorproj.httpsgithub.jobber;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MK on 26-11-2017.
 */
@IgnoreExtraProperties
public class HitsList {

    @SerializedName("hits")
    @Expose
    private List<JobSource> jobIndex;

    public void setJobIndex(List<JobSource> jobIndex) {
        this.jobIndex = jobIndex;
    }

    public List<JobSource> getJobIndex() {
        return jobIndex;
    }
}
