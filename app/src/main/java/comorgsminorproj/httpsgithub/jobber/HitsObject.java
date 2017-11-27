package comorgsminorproj.httpsgithub.jobber;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MK on 26-11-2017.
 */
@IgnoreExtraProperties
public class HitsObject {

    @SerializedName("hits")
    @Expose
    private HitsList hits;

    public HitsList getHits() {
        return hits;
    }

    public void setHits(HitsList hits) {
        this.hits = hits;
    }
}
